repo-official [link](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md)
POIs = Points Of Interest /  Pontos de Interesses

---
## Requisitos de ambiente basico
- [x] Instalar IDE java
- [x] Configurar github na IDE 
- [x] Criar um repo com os arquivos do init-spring
- [x] Criar modelagem MVC
- [x] Criar model do POI ( com 03 atributos: nome do POI, coordenada X (inteiro não negativo))
- [x] Criar repositorio para o POI
- [x] Criar conexão com banco H2
- [x] Criar primeiro controller para cadastrar ROI
- [x] Criar primeiro ROI com sucesso e salvar em banco
---
## Requisitos
- [x] Cadastrar pontos de interesse, com 03 atributos: nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo).
- [x] Os POIs devem ser armazenados em uma base de dados.
- [x] Listar todos os POIs cadastrados.
- [x] Listar os POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.
---
Na criação do POI precisamos baseado na solicitação coordenadas int não negativos, assim entramos em validação de data da entidade.

Primeiro adicionamos a dependence de validação do spring boot starter validation 
~~~xml
<dependency>  
<groupId>org.hibernate.validator</groupId> 
	    <artifactId>hibernate-validator</artifactId>  
</dependency>
~~~
Importamos a validação em nossa entity com o método PositiveOrZero
![[Pasted image 20250724124119.png]]
E no controller colocamos a anotação @Valid no momento em que criamos um POI
![[Pasted image 20250724125724.png]]
- [x] Cadastrar pontos de interesse, com 03 atributos: nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo).

![[Pasted image 20250724152747.png]]
- [x] Os POIs devem ser armazenados em uma base de dados.

![[Pasted image 20250724153010.png]]
- [x] Listar todos os POIs cadastrados.

![[Pasted image 20250724153112.png]]
- [x] Listar os POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

Minha solução para o problema foi:
![[Pasted image 20250724174935.png]]
Recebe RX e RY + DMAX
puxa coord_x e coord_y do banco e subtrai com RX e RY e se em ambas forem menor ou igual a DMAX retorna na lista todas coordenadas.
![[Pasted image 20250724183324.png]]

Mas depois percebi que ele não funcionava quando a subtração dava um numero negativo e retornava Churrascaria que não era esperado.
Assim era necessário usar a
 **distância euclidiana** entre dois pontos
  $(x1, y1) e (x2, y2):$
 $distância = √((x2 - x1)² + (y2 - y1)²)$
 E não teve como depois o chatgpt cuspiu o método pronto
 ~~~java
 public List<Poi> getPoisByDistance(int refX, int refY, int dmax) {
    return poiRepository.findAll().stream()
            .filter(p -> {
                double distancia = Math.sqrt(
                        Math.pow(p.getCoord_x() - refX, 2) +
                        Math.pow(p.getCoord_y() - refY, 2)
                );
                return distancia <= dmax;
            })
            .collect(Collectors.toList());
}

 ~~~~
 Assim finalmente retornando a lista certa sem a Churrascaria.
 ![[Pasted image 20250724183455.png]]
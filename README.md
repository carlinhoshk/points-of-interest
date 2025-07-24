# API de Pontos de Interesse GPS

Uma API REST em Spring Boot para gerenciar e consultar Pontos de Interesse (POIs) com coordenadas GPS.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **Banco de Dados H2**
- **Lombok**
- **Maven**
- **Hibernate Validator**

## 🏗️ Funcionalidades

- Criar novos Pontos de Interesse (POI) com nome e coordenadas
- Listar todos os POIs cadastrados
- Encontrar POIs próximos a um ponto de referência dentro de uma distância máxima com euclidiana 
- Validação de dados para coordenadas não negativas

## 🚀 Começando

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6.3 ou superior

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/gps-api.git
   cd gps-api
   ```

2. Construa o projeto:
   ```bash
   mvn clean install
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação será iniciada em `http://localhost:8080`

## 📚 Referência da API

### Criar um novo POI
```http
POST /api/rois/salvar_poi
Content-Type: application/json

{
  "name": "Lanchonete",
  "coord_x": 27,
  "coord_y": 12
}
```

### Listar todos os POIs
```http
GET /api/rois/listar_pois
```

### Encontrar POIs por proximidade (método de subtração simples)
```http
GET /api/rois/listar_pois_d?x=20&y=10&dmax=10
```

### Encontrar POIs por distância (método Euclidiano)
```http
GET /api/rois/listar_poisd?x=20&y=10&dmax=10
```

## 📝 Exemplo de Uso

1. Criar um novo POI:
   ```bash
   curl -X POST http://localhost:8080/api/rois/salvar_poi \
     -H "Content-Type: application/json" \
     -d '{"name":"Lanchonete","coord_x":27,"coord_y":12}'
   ```

2. Listar todos os POIs cadastrados:
   ```bash
   curl http://localhost:8080/api/rois/listar_pois
   ```

3. Encontrar POIs próximos usando o método de subtração simples:
   ```bash
   curl "http://localhost:8080/api/rois/listar_pois_d?x=20&y=10&dmax=10"
   ```

4. Encontrar POIs próximos usando o método Euclidiano (mais preciso):
   ```bash
   curl "http://localhost:8080/api/rois/listar_poisd?x=20&y=10&dmax=10"
   ```
   
   Exemplo de resposta:
   ```json
   [
     {
       "name": "Lanchonete",
       "x": 27,
       "y": 12
     },
     {
       "name": "Joalheria",
       "x": 15,
       "y": 12
     },
     {
       "name": "Pub",
       "x": 12,
       "y": 8
     },
     {
       "name": "Supermercado",
       "x": 23,
       "y": 6
     }
   ]
   ```

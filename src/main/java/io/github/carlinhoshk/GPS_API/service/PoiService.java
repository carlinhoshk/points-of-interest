package io.github.carlinhoshk.GPS_API.service;

import io.github.carlinhoshk.GPS_API.model.Poi;
import io.github.carlinhoshk.GPS_API.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoiService {

    private final List<Poi> pois = new ArrayList<>();
    @Autowired
    private PoiRepository poiRepository;

    public List<Poi> getAllPois(){
        return poiRepository.findAll();
    }

    public Poi savePoi(Poi poi){
        return poiRepository.save(poi);
    }

    // A minha soluçao: Pegar os 2 parametros de coordenadas e subtrair pelas coordenadas do banco se o resultado dessa subtraçao
    // for menor ou igual a DMAX entao retorna na lista. Porem percebi que quando a subtraçao da negativa o resultado pode vir errado
    public List<Poi> getPoisByProximity(int rx, int ry, int dmax){
        return poiRepository.findAll().stream()
                .filter(p ->
                        (p.getCoord_x() - rx) <= dmax && (p.getCoord_y() - ry) <= dmax
                )
                .collect(Collectors.toList());
    }
    // Soluçao usando a distância Euclidiana
    public List<Poi> getPoisByDistance(int rx, int ry, int dmax) {
        return poiRepository.findAll().stream()
                .filter(p -> {
                    double distancia = Math.sqrt(
                            Math.pow(p.getCoord_x() - rx, 2) +
                                    Math.pow(p.getCoord_y() - ry, 2)
                    );
                    return distancia <= dmax;
                })
                .collect(Collectors.toList());
    }


}

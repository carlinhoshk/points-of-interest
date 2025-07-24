package io.github.carlinhoshk.GPS_API.service;

import io.github.carlinhoshk.GPS_API.model.Poi;
import io.github.carlinhoshk.GPS_API.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiService {
    @Autowired
    private PoiRepository poiRepository;

    public List<Poi> getAllPois(){
        return poiRepository.findAll();
    }

    public Poi savePoi(Poi poi){
        return poiRepository.save(poi);
    }

}

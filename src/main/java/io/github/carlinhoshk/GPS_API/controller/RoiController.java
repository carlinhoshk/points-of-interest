package io.github.carlinhoshk.GPS_API.controller;

import io.github.carlinhoshk.GPS_API.model.Poi;
import io.github.carlinhoshk.GPS_API.repository.PoiRepository;
import io.github.carlinhoshk.GPS_API.service.PoiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rois")
public class RoiController {
    @Autowired
    private PoiService poiService;
    private PoiRepository poiRepository;

    @GetMapping("/listar_pois")
    public List<Poi> listarPois(){
        return poiService.getAllPois();
    }

    @PostMapping("/salvar_poi")
    public ResponseEntity<Poi> createPoi(@Valid @RequestBody Poi poi){
        Poi saved = poiService.savePoi(poi);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

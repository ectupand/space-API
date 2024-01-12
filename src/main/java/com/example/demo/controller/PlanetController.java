package com.example.demo.controller;

import com.example.demo.entity.Planet;
import com.example.demo.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/planet")
public class PlanetController {
    private PlanetService planetService;

    @GetMapping
    public ResponseEntity<List<Planet>> readAll(){
        return new ResponseEntity<>(planetService.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet){
        return new ResponseEntity<>(planetService.create(planet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        planetService.delete(id);
        return HttpStatus.OK;
    }
}

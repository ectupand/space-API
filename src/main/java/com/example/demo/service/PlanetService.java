package com.example.demo.service;

import com.example.demo.entity.Lord;
import com.example.demo.entity.Planet;
import com.example.demo.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanetService {
    private final PlanetRepository planetRepository;

    public List<Planet> readAll(){
        return planetRepository.findAll();
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }

    public void delete(Long id){
        planetRepository.deleteById(id);
    }
}

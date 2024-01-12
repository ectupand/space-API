package com.example.demo.service;

import com.example.demo.entity.Lord;
import com.example.demo.entity.Planet;
import com.example.demo.repository.LordRepository;
import com.example.demo.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LordService {
    private final LordRepository lordRepository;
    private final PlanetRepository planetRepository;

    public Lord create(Lord lord){
        return lordRepository.save(lord);
    }

    public List<Lord> readAll(){
        return lordRepository.findAll();
    }

    public Lord ownPlanet(Long lordId, Long planetId){
        Optional<Planet> _planet = planetRepository.findById(planetId);
        Optional<Lord> _lord = lordRepository.findById(lordId);
        if (_planet.isEmpty() || _lord.isEmpty()){
            return null;
        }
        Planet planet = _planet.get();
        Lord lord = _lord.get();
        planet.setLord(lord);
        return lord;
    }

    public List<Lord> findSlackers(){
        return lordRepository.findByAgeOrderByAgeAgeAsc();
    }

}

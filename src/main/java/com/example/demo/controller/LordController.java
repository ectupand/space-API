package com.example.demo.controller;

import com.example.demo.entity.Lord;
import com.example.demo.service.LordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/lord")
public class LordController {
    private final LordService lordService;

    @GetMapping
    public ResponseEntity<List<Lord>> readAll(){
        return new ResponseEntity<>(lordService.readAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Lord>> readTop10Young(){
        return new ResponseEntity<>(lordService.findSlackers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lord> create(@RequestBody Lord lord){
        return new ResponseEntity<>(lordService.create(lord), HttpStatus.OK);
    }

    @PutMapping("/{lordId}")
    public ResponseEntity<Lord> updatePlanet(@PathVariable Long lordId, @RequestBody Long planetId){
        return new ResponseEntity<>(lordService.ownPlanet(lordId, planetId), HttpStatus.OK);
    }

}

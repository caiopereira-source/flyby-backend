package br.com.gamean.flyby.controller;

import br.com.gamean.flyby.dto.FlightDto;
import br.com.gamean.flyby.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping
    public ResponseEntity<FlightDto> create(@RequestBody FlightDto flightDto) {
        FlightDto flight = service.create(flightDto);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> findById(@PathVariable("id") long id){
        var flight = service.findById(id);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<FlightDto> update(@RequestBody FlightDto flightDto){
        FlightDto flight = service.update(flightDto);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> findAll(){
        var flights = service.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}

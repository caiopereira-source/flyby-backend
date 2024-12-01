package br.com.gamean.flyby.controller;

import br.com.gamean.flyby.dto.FlightDto;
import br.com.gamean.flyby.dto.PassengerDto;
import br.com.gamean.flyby.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService service;

    @PostMapping
    public ResponseEntity<PassengerDto> create (@RequestBody PassengerDto passengerDto){
        PassengerDto passenger = service.create(passengerDto);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> findById(@PathVariable("id") long id){
        var passenger = service.findById(id);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<PassengerDto> update(@RequestBody PassengerDto passengerDto){
        PassengerDto passenger = service.update(passengerDto);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PassengerDto>> findAll(){
        var passengers = service.findAll();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }
}

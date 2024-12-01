package br.com.gamean.flyby.service;

import br.com.gamean.flyby.dto.FlightDto;
import br.com.gamean.flyby.exception.ResourceNotFoundException;
import br.com.gamean.flyby.mapper.CustomModelMapper;
import br.com.gamean.flyby.model.FlightModel;
import br.com.gamean.flyby.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public FlightDto create(FlightDto flightDto){
        FlightModel flight = CustomModelMapper.parseObject(flightDto, FlightModel.class);
        return CustomModelMapper.parseObject(repository.save(flight), FlightDto.class);
    }

    public FlightDto findById(long id){
        FlightModel found = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Voo inválido!")
        );
        return CustomModelMapper.parseObject(found, FlightDto.class);
    }

    public FlightDto update(FlightDto flightDto){
        FlightModel flightModel = repository.findById(flightDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Voo não encontrado!")
        );
        flightModel.setDeparture(flightDto.getDeparture());
        flightModel.setDestination(flightDto.getDestination());
        flightModel.setAirport(flightDto.getAirport());

        return CustomModelMapper.parseObject(repository.save(flightModel), FlightDto.class);
    }

    public void delete(long id){
        FlightModel flightModel = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Voo não encontrado!")
        );
        repository.delete(flightModel);
    }

    public List<FlightDto> findAll(){
        var list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, FlightDto.class);
    }




}

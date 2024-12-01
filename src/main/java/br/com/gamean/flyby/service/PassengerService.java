package br.com.gamean.flyby.service;


import br.com.gamean.flyby.dto.FlightDto;
import br.com.gamean.flyby.dto.PassengerDto;
import br.com.gamean.flyby.exception.ResourceNotFoundException;
import br.com.gamean.flyby.mapper.CustomModelMapper;
import br.com.gamean.flyby.model.FlightModel;
import br.com.gamean.flyby.model.PassengerModel;
import br.com.gamean.flyby.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repository;

    public PassengerDto create(PassengerDto passengerDto){
        PassengerModel passenger = CustomModelMapper.parseObject(passengerDto, PassengerModel.class);
        return CustomModelMapper.parseObject(repository.save(passenger), PassengerDto.class);
    }

    public PassengerDto findById(long id){
        PassengerModel found = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Passageiro não encontrado!"));
        return CustomModelMapper.parseObject(found, PassengerDto.class);

    }

    public PassengerDto update(PassengerDto passengerDto){
        PassengerModel passengerModel = repository.findById(passengerDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Passageiro não encontrado!")
        );
        passengerModel.setName(passengerDto.getName());
        passengerModel.setCpf(passengerDto.getCpf());
        passengerModel.setPhoneNumber(passengerDto.getPhoneNumber());

        passengerModel.setFlight(CustomModelMapper.parseObject(passengerDto.getFlight(), FlightModel.class));

        return CustomModelMapper.parseObject(repository.save(passengerModel), PassengerDto.class);
    }

    public void delete(long id){
        PassengerModel found = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Passageiro não encontrado!"));
        repository.delete(found);
    }

    public List<PassengerDto> findAll(){
        var list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, PassengerDto.class);
    }
}

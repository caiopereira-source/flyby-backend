package br.com.gamean.flyby.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class PassengerDto {

    private long id;
    private String name;
    private long cpf;
    private long phoneNumber;
    private FlightDto flight;
}

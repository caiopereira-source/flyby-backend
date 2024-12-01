package br.com.gamean.flyby.dto;

import br.com.gamean.flyby.model.FlightModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class FlightDto{
    private long id;
    private String departure;
    private String destination;
    private String airport;
}

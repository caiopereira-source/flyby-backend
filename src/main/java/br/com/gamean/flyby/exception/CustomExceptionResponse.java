package br.com.gamean.flyby.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CustomExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;
}

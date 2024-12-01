package br.com.gamean.flyby.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 128)
    private String departure;

    @Column(nullable = false, length = 128)
    private String destination;

    @Column(nullable = false, length = 128)
    private String airport;
}

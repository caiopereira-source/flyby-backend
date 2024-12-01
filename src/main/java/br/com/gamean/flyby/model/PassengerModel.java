package br.com.gamean.flyby.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "passenger")
public class PassengerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 11)
    private long cpf;

    @Column(nullable = false, length = 13)
    private long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightModel flight;
}

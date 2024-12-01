package br.com.gamean.flyby.repository;

import br.com.gamean.flyby.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Long> {


}

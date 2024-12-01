package br.com.gamean.flyby.repository;

import br.com.gamean.flyby.model.PassengerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerModel, Long> {
}

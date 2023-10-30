package washit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import washit.backend.model.Reservation;
import washit.backend.model.WashingMachine;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.username = :username ORDER BY r.starttime DESC")
    Reservation findByUsername(@Param("username") String username);

    @Query("SELECT r FROM Reservation r WHERE r.washingMachine = :machine AND r.starttime > :afterTime ORDER BY r.starttime ASC")
    Reservation findTopByWashingMachineAndStarttimeAfterOrderByStarttime(@Param("machine") WashingMachine machine, @Param("afterTime") LocalDateTime afterTime);

}

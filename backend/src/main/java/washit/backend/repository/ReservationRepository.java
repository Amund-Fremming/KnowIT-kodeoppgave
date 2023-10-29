package washit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import washit.backend.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

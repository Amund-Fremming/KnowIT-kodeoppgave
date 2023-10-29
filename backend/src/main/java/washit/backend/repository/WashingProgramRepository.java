package washit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import washit.backend.model.WashingProgram;

@Repository
public interface WashingProgramRepository extends JpaRepository<WashingProgram, Long> {
}

package washit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import washit.backend.model.WaitEntry;

@Repository
public interface WaitEntryRepository extends JpaRepository<Long, WaitEntry> {
}

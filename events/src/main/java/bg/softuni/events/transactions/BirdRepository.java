package bg.softuni.events.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Long> {
}

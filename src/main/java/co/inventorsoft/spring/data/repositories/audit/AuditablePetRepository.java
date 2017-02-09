package co.inventorsoft.spring.data.repositories.audit;

import co.inventorsoft.spring.data.model.AuditablePet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anatolii vakaliuk
 */
public interface AuditablePetRepository extends JpaRepository<AuditablePet, Long> {
}

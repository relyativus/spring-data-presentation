package co.inventorsoft.spring.data.repositories.audit;

import co.inventorsoft.spring.data.model.AuditableUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anatolii vakaliuk
 */
public interface AuditableUserRepository extends JpaRepository<AuditableUser, Long> {
}

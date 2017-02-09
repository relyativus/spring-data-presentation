package co.inventorsoft.spring.data.repositories.audit;

import co.inventorsoft.spring.data.model.AuditableUser;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author anatolii vakaliuk
 */
@Component
@AllArgsConstructor
public class SimpleUserAuditorAware implements AuditorAware<AuditableUser> {

    private AuditableUserRepository auditableUserRepository;

    @Override
    public AuditableUser getCurrentAuditor() {
        return auditableUserRepository.findOne(1L);
    }
}

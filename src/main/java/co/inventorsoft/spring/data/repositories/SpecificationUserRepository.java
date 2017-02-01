package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author anatolii vakaliuk
 */
public interface SpecificationUserRepository
        extends CrudRepository<SimpleUser, Long>, JpaSpecificationExecutor<SimpleUser> {
}

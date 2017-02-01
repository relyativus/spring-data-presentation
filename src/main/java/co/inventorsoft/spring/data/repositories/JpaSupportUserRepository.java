package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anatolii vakaliuk
 */
public interface JpaSupportUserRepository extends JpaRepository<SimpleUser, Long> {

}

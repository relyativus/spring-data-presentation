package co.inventorsoft.spring.data.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author anatolii vakaliuk
 */
@NoRepositoryBean
public interface OptionalSupportRepository<E, ID extends Serializable> {

    Optional<E> findById(ID id);
}

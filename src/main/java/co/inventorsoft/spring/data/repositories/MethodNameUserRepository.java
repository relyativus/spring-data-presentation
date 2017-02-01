package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Defines methods which will be translated to queries by spring data
 * part tree
 *
 * @author anatolii vakaliuk
 */
public interface MethodNameUserRepository extends CrudRepository<SimpleUser, Long> {

    List<SimpleUser> findByFirstName(final String firstName);

    SimpleUser findFirstByFirstNameOrderById(final String firstName);

    List<SimpleUser> getByFirstNameContains(String value, Sort sort);

    Page<SimpleUser> readByFirstNameLike(String value, Pageable sort);

    boolean existsByLastName(final String lastName);
}

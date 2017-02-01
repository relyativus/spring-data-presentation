package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author anatolii vakaliuk
 */
public interface ModifyingUserRepository extends CrudRepository<SimpleUser, Long> {

    int removeByLastName(final String lastName);

    @Modifying
    @Query("update SimpleUser u set u.lastName = :newLastName where u.lastName = :oldLastName")
    int updateUsersWithLastName(@Param("oldLastName") String oldLastName,
                                @Param("newLastName") String newLastName);
}

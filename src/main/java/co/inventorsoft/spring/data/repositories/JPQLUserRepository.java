package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author anatolii vakaliuk
 */
public interface JPQLUserRepository extends CrudRepository<SimpleUser, Long> {

    @Query("select u from SimpleUser u where u.firstName = :firstName")
    List<SimpleUser> findUserByFirstName(@Param("firstName") String firstName);

    @Query("select u from SimpleUser u join u.orders o where o.id = :orderId")
    List<SimpleUser> findUsersWithOrder(@Param("orderId") Long orderId);
}

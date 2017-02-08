package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 * @author anatolii vakaliuk
 */
public interface JpaSupportUserRepository extends JpaRepository<SimpleUser, Long> {

    @Query(name = "findById")
    SimpleUser executeNamedQuery(@Param("userId") long id);

    @EntityGraph(attributePaths = "orders")
    @Query("select su from SimpleUser su where su.id = :userId")
    SimpleUser findUserWithOrders(@Param("userId") long id);
}

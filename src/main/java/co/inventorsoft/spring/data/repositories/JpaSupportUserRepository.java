package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author anatolii vakaliuk
 */
public interface JpaSupportUserRepository extends JpaRepository<SimpleUser, Long> {

    @Query(name = "findById")
    SimpleUser executeNamedQuery(@Param("userId") Long userId);

    @EntityGraph(value = "userWithOrders", type = EntityGraph.EntityGraphType.FETCH, attributePaths = "orders")
    @Query("select u from SimpleUser u where u.id = :userId")
    SimpleUser findUserWithOrders(@Param("userId") Long id);

}

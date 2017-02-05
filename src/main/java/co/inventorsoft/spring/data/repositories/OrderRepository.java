package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author anatolii vakaliuk
 */
public interface OrderRepository extends CrudRepository<Order, Long>, OrderRepositoryCustom {
}

package co.inventorsoft.spring.data.repositories.spec;

import co.inventorsoft.spring.data.model.Order;
import co.inventorsoft.spring.data.repositories.SpelSupportRepository;
import org.springframework.data.repository.Repository;

/**
 * @author anatolii vakaliuk
 */
public interface SpelSupportOrderRepository extends SpelSupportRepository, Repository<Order, Long> {

}

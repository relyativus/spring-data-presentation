package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.Order;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author anatolii vakaliuk
 */
public interface PostProcessResultOrderRepository extends Repository<Order, Long> {

    Stream<Order> findAll();

    @Query(name = "findOrderById")
    Optional<Order> findGuavaOptional(@Param("orderId") Long id);

    @Query(name = "findOrderById")
    java.util.Optional<Order> findJavaOptional(@Param("orderId") Long id);

    @Async
    CompletableFuture<java.util.Optional<Order>> findById(Long id);
}

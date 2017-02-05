package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.OrdersCountDTO;

import java.util.List;

/**
 * @author anatolii vakaliuk
 */
public interface OrderRepositoryCustom {

    List<OrdersCountDTO> findOrdersCountGroupedByUser();
}

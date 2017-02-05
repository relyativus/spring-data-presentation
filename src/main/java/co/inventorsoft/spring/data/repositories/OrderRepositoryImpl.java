package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.OrdersCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author anatolii vakaliuk
 */
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<OrdersCountDTO> findOrdersCountGroupedByUser() {
        return jdbcTemplate.query(
                "SELECT u.id as id, count(o.id) as ordersCount " +
                        "FROM simple_users u left join orders o on o.user_id=o.id GROUP BY u.id ORDER BY u.id",
                (resultSet, rowNum) -> new OrdersCountDTO(resultSet.getLong("id"), resultSet.getLong("ordersCount"))
        );
    }
}

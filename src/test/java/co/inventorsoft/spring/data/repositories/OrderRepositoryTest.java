package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.OrdersCountDTO;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/native/users.xml")
@DatabaseTearDown(value = "classpath:dbunit/native/teardown.xml")
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindOrdersCountGroupedByUserExecutesThroughJdbc() {
        List<OrdersCountDTO> countGroupedByUser = orderRepository.findOrdersCountGroupedByUser();
        assertEquals(3, countGroupedByUser.size());
        assertEquals(1L, (long) countGroupedByUser.get(0).getOrdersCount());
        assertEquals(0L, (long) countGroupedByUser.get(1).getOrdersCount());
        assertEquals(0L, (long) countGroupedByUser.get(2).getOrdersCount());
    }
}

package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.repositories.spec.SpelSupportOrderRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/postProcess/orders.xml")
@DatabaseTearDown
public class SpelSupportOrderRepositoryTest {

    @Autowired
    private SpelSupportOrderRepository spelSupportOrderRepository;

    @Test
    public void testGetMaxIdReturnsMaxPrimaryKeyValue() {
        int maxId = spelSupportOrderRepository.getMaxId();
        assertEquals(2L, maxId);
    }

}

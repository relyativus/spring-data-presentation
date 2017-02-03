package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.OrdersCount;
import co.inventorsoft.spring.data.model.SimpleUser;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/native/users.xml")
@DatabaseTearDown(value = "classpath:dbunit/native/teardown.xml")
public class NativeQuerySupportRepositoryTest {

    @Autowired
    private NativeQuerySupportRepository nativeQuerySupportRepository;

    @Test
    public void testFindUsersNativeReturnsUser() {
        List<SimpleUser> usersNative = nativeQuerySupportRepository.findUsersNative(1L);
        assertEquals(1L, usersNative.size());

    }

    @Test
    public void testFindUserNativeWithProjection() {
        final List<OrdersCount> ordersCountForUsers = nativeQuerySupportRepository.findOrdersCountForUsers();
        assertEquals(3, ordersCountForUsers.size());
    }
}

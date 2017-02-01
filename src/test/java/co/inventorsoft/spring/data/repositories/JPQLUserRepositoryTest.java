package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.SimpleUser;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/jpql/userWithOrder.xml")
@DatabaseTearDown(value = "classpath:dbunit/jpql/tearDown.xml")
public class JPQLUserRepositoryTest {

    @Autowired
    private JPQLUserRepository jpqlUserRepository;

    @Test
    public void testFindUsersByFirstNameReturnsUsersWithFirstNameEqual() {
        String searchCriteria = "Ivo";
        List<SimpleUser> jamesUsers = jpqlUserRepository.findUserByFirstName(searchCriteria);
        assertEquals(jamesUsers.size(), 1);
        assertTrue(jamesUsers.stream().map(SimpleUser::getFirstName).allMatch(fn -> fn.equals(searchCriteria)));
    }

    @Test
    public void testFindUsersWithOrderReturnsUsersWhichRelatedToSpecificOrder() {
        List<SimpleUser> usersWithOrder = jpqlUserRepository.findUsersWithOrder(1L);
        assertEquals(usersWithOrder.size(), 1);
        assertEquals(usersWithOrder.get(0).getFirstName(), "Stephan");
        assertTrue(usersWithOrder.get(0).getOrders().stream().anyMatch(o -> o.getId().equals(1L)));
    }


}

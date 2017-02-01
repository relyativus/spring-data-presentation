package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.SimpleUser;
import co.inventorsoft.spring.data.repositories.spec.UsersFilterSpecificationBuilder;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/dynamic/users.xml")
@DatabaseTearDown
public class SpecificationUserRepositoryTest {

    @Autowired
    private SpecificationUserRepository specificationUserRepository;

    @Test
    public void testFindAllReturnsAllUsersWhenFiltersAreNotSet() {
        Specification<SimpleUser> specification = new UsersFilterSpecificationBuilder().build();
        List<SimpleUser> users = specificationUserRepository.findAll(specification);
        assertEquals(3, users.size());
    }

    @Test
    public void testFindAllReturnsUsersWithFirstNameMatchWhenFirstNameFilterIsSet() {
        Specification<SimpleUser> specification = new UsersFilterSpecificationBuilder()
                .setFirstName("Oksana")
                .build();
        List<SimpleUser> users = specificationUserRepository.findAll(specification);
        assertEquals(1, users.size());
        assertEquals("Oksana", users.get(0).getFirstName());
    }

    @Test
    public void testFindAllReturnsUsersWithLastNameMatchWhenLastNameFilterIsSet() {
        Specification<SimpleUser> specification = new UsersFilterSpecificationBuilder()
                .setLastName("Giga")
                .build();
        List<SimpleUser> users = specificationUserRepository.findAll(specification);
        assertEquals(1, users.size());
        assertEquals("Giga", users.get(0).getLastName());
    }

    @Test
    public void testFindAllReturnsUsersWithLastNameAndFirstNameMatchWhenLastNameAndFirstNameFilterIsSet() {
        Specification<SimpleUser> specification = new UsersFilterSpecificationBuilder()
                .setLastName("Giga")
                .setFirstName("Ivo")
                .build();
        List<SimpleUser> users = specificationUserRepository.findAll(specification);
        assertEquals(2, users.size());
        assertTrue(users.stream().allMatch(user -> user.getFirstName().equals("Ivo")
                || user.getLastName().equals("Giga")));
    }
}

package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.SimpleUser;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/methodname/simpleUsersData.xml")
@DatabaseTearDown
public class MethodNameUserRepositoryTest {

    @Autowired
    private MethodNameUserRepository methodNameUserRepository;

    @Test
    public void testFindByFirstNameReturnsUsersWithFirstNameEqual() {
        List<SimpleUser> jimmyUsers = methodNameUserRepository.findByFirstName("Jimmy");
        assertEquals(jimmyUsers.size(), 2);
        assertTrue(jimmyUsers.stream().allMatch(user -> user.getFirstName().equals("Jimmy")));
        assertTrue(jimmyUsers.stream().anyMatch(user -> user.getLastName().equals("Hendrix")));
        assertTrue(jimmyUsers.stream().anyMatch(user -> user.getLastName().equals("Page")));
    }

    @Test
    public void testFindFirstByFirstNameOrderByIdReturnsSingleUserWithFirstNameEqualAndLowestId() {
        SimpleUser user = methodNameUserRepository.findFirstByFirstNameOrderById("Jimmy");
        assertNotNull(user);
        assertEquals(user.getFirstName(), "Jimmy");
        assertEquals((long) user.getId(), 1L);
    }

    @Test
    public void testGetByFirstNameContainsReturnsUsersWhichFirstNameContainsOrderedByLastName() {
        String searchCriteria = "J";
        List<String> lastNames = Arrays.asList("Hendrix", "Hetfield", "Page");
        List<SimpleUser> users = methodNameUserRepository.getByFirstNameContains(searchCriteria,
                new Sort(Sort.Direction.ASC, "lastName"));
        assertEquals(3, users.size());
        assertTrue(users.stream().map(SimpleUser::getFirstName).allMatch(fn -> fn.contains(searchCriteria)));
        assertOrder(lastNames, mapTo(users, SimpleUser::getLastName));
    }

    @Test
    public void testReadByFirstNameLikeReturnsUsersMatchLikeExpressionWithPaginationSupport() {
        String searchCriteria = "K%";
        Page<SimpleUser> simpleUsers = methodNameUserRepository.readByFirstNameLike(searchCriteria,
                new PageRequest(0, 5));
        assertEquals(1, simpleUsers.getTotalElements());
        assertTrue(simpleUsers.getContent().stream().map(SimpleUser::getFirstName).allMatch(fn -> fn.startsWith("K")));
    }

    @Test
    public void testExistsByLastNameReturnsFalseWhenUserWithFirstNameIsNotFound() {
        boolean exists = methodNameUserRepository.existsByLastName("Bilozir");
        assertFalse(exists);
    }

    private <S, R> List<R> mapTo(List<S> source, Function<S, R> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }

    private void assertOrder(final List<String> expected, final List<String> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i =0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}

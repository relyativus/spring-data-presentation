package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
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
@DatabaseSetup(value = "classpath:dbunit/modifying/users.xml")
@DatabaseTearDown
public class ModifyingUserRepositoryTest {

    @Autowired
    private ModifyingUserRepository modifyingUserRepository;

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/modifying/deleteExpected.xml")
    public void testDeleteByLastNameRemovesUserWithLastNameEqual() {
        int affectedBobuls = modifyingUserRepository.removeByLastName("Bobul");
        assertEquals(2, modifyingUserRepository.count());
        assertEquals(1, affectedBobuls);
    }

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/modifying/updateExpected.xml")
    public void testUpdateUsersWithLastNameUpdateUserWithLastNameEqual() {
        int affectedRows = modifyingUserRepository.updateUsersWithLastName("Giga", "Mega");
        assertEquals(1, affectedRows);
    }
}

package co.inventorsoft.spring.data.repositories.audit;

import co.inventorsoft.spring.data.model.AuditableUser;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("auditing")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class AuditableUserRepositoryTest {

    @Autowired
    private AuditableUserRepository auditableUserRepository;

    @DatabaseTearDown("classpath:dbunit/audit/teardown.xml")
    @Test
    public void testSaveSetCreatedAndUpdatedDateToCurrent() {
        AuditableUser auditableUser = new AuditableUser();
        auditableUser.setName("Kuklachev");
        auditableUser.setId(1L);
        AuditableUser savedUser = auditableUserRepository.saveAndFlush(auditableUser);
        LocalDate currentDate = LocalDate.now();
        assertEquals(currentDate, savedUser.getCreatedAt());
        assertEquals(currentDate, savedUser.getUpdatedAt());
    }

    @DatabaseSetup("classpath:dbunit/audit/auditable.xml")
    @DatabaseTearDown("classpath:dbunit/audit/teardown.xml")
    @Test
    public void testSaveForExistedUserUpdateUpdatedAtToCurrentDate() {
        AuditableUser auditableUser = auditableUserRepository.findOne(1L);
        auditableUser.setName("Perdeev");
        AuditableUser updated = auditableUserRepository.saveAndFlush(auditableUser);
        assertEquals(LocalDate.now(), updated.getUpdatedAt());
    }
}

package co.inventorsoft.spring.data.repositories.audit;

import co.inventorsoft.spring.data.model.AuditablePet;
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

import static org.junit.Assert.*;

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
public class AuditablePetRepositoryTest {

    @Autowired
    private AuditablePetRepository auditablePetRepository;

    @Autowired
    private SimpleUserAuditorAware simpleUserAuditorAware;

    @DatabaseSetup("classpath:dbunit/audit/auditable.xml")
    @DatabaseTearDown("classpath:dbunit/audit/teardown.xml")
    @Test
    public void testSaveSetCreatedAtToCurrentDateAndCreatedByToFirstAuditableUser() {
        AuditablePet auditablePet = new AuditablePet();
        auditablePet.setId(1L);
        auditablePet.setName("Barsic");
        auditablePet.setType("Cat");
        AuditablePet createdPet = auditablePetRepository.saveAndFlush(auditablePet);
        assertEquals(LocalDate.now(), createdPet.getCreatedAt());
        assertEquals(LocalDate.now(), createdPet.getUpdatedAt());
        assertTrue(simpleUserAuditorAware.getCurrentAuditor().getId().equals(createdPet.getCreator().getId()));
        assertTrue(simpleUserAuditorAware.getCurrentAuditor().getId().equals(createdPet.getUpdater().getId()));
    }

    @DatabaseSetup("classpath:dbunit/audit/auditableUpdate.xml")
    @DatabaseTearDown("classpath:dbunit/audit/teardown.xml")
    @Test
    public void testSaveUpdateUpdatedAtAndUpdater() {
        AuditablePet auditablePet = auditablePetRepository.findOne(1L);
        auditablePet.setType("Dog");
        auditablePet.setName("Spike");

        AuditablePet updatetPet = auditablePetRepository.saveAndFlush(auditablePet);
        assertNull(updatetPet.getCreatedAt());
        assertEquals(LocalDate.now(), updatetPet.getUpdatedAt());
        assertNull(updatetPet.getCreator());
        assertTrue(simpleUserAuditorAware.getCurrentAuditor().getId().equals(updatetPet.getUpdater().getId()));
    }
}

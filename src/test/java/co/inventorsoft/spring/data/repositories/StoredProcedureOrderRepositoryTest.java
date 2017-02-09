/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("storedProcedure")
@DAOTest
public class StoredProcedureOrderRepositoryTest {

    @Autowired
    private StoredProcedureOrderRepository storedProcedureOrderRepository;

    @Test
    public void testBinaryAdd() {
        final Long[] sum = storedProcedureOrderRepository.binaryAdd(2L, 2L);
        assertEquals(4L, (long) sum[0]);
    }
}

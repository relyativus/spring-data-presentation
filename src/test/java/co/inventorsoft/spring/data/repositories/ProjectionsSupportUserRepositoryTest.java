/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.OrderInfo;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/native/users.xml")
public class ProjectionsSupportUserRepositoryTest {

    @Autowired
    private ProjectionsSupportUserRepository projectionsSupportUserRepository;

    @Test
    public void testFindByIdWithOpenedProjection() {
        final List<OrderInfo> orderInfos = projectionsSupportUserRepository.findById(1L);
        assertFalse(orderInfos.isEmpty());
        final OrderInfo orderInfo = orderInfos.get(0);
        assertEquals((long)orderInfo.getId(), 1L);
        assertEquals("Ivo Bobul", orderInfo.getFullName());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.SimpleUser;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/jpa/usersWithOrders.xml")
@DatabaseTearDown(value = "classpath:dbunit/jpa/tearDown.xml")
public class JpaSupportUserRepositoryTest {

    @Autowired
    private JpaSupportUserRepository jpaSupportUserRepository;

    @Test
    public void testNamedQueryExecutedCorrectly() {
        final SimpleUser simpleUser = jpaSupportUserRepository.executeNamedQuery(2L);
        assertNotNull(simpleUser);
        assertEquals((long) simpleUser.getId(), 2L);
    }

    @Test
    public void testEntityGraphQueryLoadsRelationWithLeftJoin() {
        final SimpleUser userWithOrders = jpaSupportUserRepository.findUserWithOrders(2L);
        assertNotNull(userWithOrders);
        assertEquals((long) userWithOrders.getId(), 2L);
        assertFalse(userWithOrders.getOrders().isEmpty());
    }

    @Test
    public void testGetEntityReferenceReturnsProxy() {
        final SimpleUser userReference = jpaSupportUserRepository.getOne(1L);
        assertNotEquals(SimpleUser.class, userReference.getClass());
    }

    @Test
    public void testFindOneReturnsActualObject() {
        final SimpleUser userReference = jpaSupportUserRepository.findOne(1L);
        assertEquals(SimpleUser.class, userReference.getClass());
    }

}

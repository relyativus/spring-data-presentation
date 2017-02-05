/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.UserInfo;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        final List<UserInfo> userInfos = projectionsSupportUserRepository.findById(1L);
        assertFalse(userInfos.isEmpty());
        final UserInfo userInfo = userInfos.get(0);
        assertEquals((long) userInfo.getId(), 1L);
        assertEquals("Ivo Bobul", userInfo.getFullName());
    }

    @Test
    public void testFindUserInfosDoesNotFailsWithPageable() {
        final Page<UserInfo> userInfos = projectionsSupportUserRepository.findOrderInfos(new PageRequest(0, 3));
        assertEquals(3, userInfos.getTotalElements());
        assertEquals(3, userInfos.getNumberOfElements());
    }
}

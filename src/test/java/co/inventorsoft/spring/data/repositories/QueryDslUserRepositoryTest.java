/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.DAOTest;
import co.inventorsoft.spring.data.model.SimpleUser;
import co.inventorsoft.spring.data.repositories.predicates.QueryDslUserPredicateBuilder;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@DAOTest
@DatabaseSetup(value = "classpath:dbunit/native/users.xml")
@DatabaseTearDown(value = "classpath:dbunit/native/teardown.xml")
public class QueryDslUserRepositoryTest {

    @Autowired
    private QueryDslUserRepository queryDslUserRepository;

    @Test
    public void testFindAllWithOptionalId() {
        final Predicate predicate = new QueryDslUserPredicateBuilder()
                .setFirstName("Oks")
                .build();
        final SimpleUser simpleUser = queryDslUserRepository.findOne(predicate);
        assertTrue(simpleUser.getFirstName().equals("Oksana"));
    }
}

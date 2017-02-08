/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;

/**
 * @author anatolii
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:dbunit/dynamic/users.xml")
@DatabaseTearDown
public class FutureSupportUserRepositoryTest {

    @Autowired
    private FutureSupportUserRepository futureSupportUserRepository;


    @Test
    public void testFindByIdExecutedAsynchronously() throws ExecutionException, InterruptedException {
        final CompletableFuture<List<SimpleUser>> userFuture = futureSupportUserRepository.findAll();
        assertFalse(userFuture.isDone());
        while (!userFuture.isDone()) {
            System.out.println("Waiting for the CompletableFuture to finish...");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        assertFalse(userFuture.get().isEmpty());
    }
}

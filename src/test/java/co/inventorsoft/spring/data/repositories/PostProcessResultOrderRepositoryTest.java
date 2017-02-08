package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.Order;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.google.common.base.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author anatolii vakaliuk
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:dbunit/postProcess/orders.xml")
@DatabaseTearDown
public class PostProcessResultOrderRepositoryTest {

    @Autowired
    private PostProcessResultOrderRepository postProcessResultOrderRepository;

    @Test
    public void testFindAllReturnsResultAsStream() {
        try (Stream<Order> orderStream = postProcessResultOrderRepository.findAll()){
            String ordersTitleJoined = orderStream.map(Order::getTitle).collect(Collectors.joining(","));
            assertEquals("Funny Costume,Black Jack with Sluts", ordersTitleJoined);
        }
    }

    @Test
    public void testFindGuavaOptionalReturnsGuavaOptional() {
        Optional<Order> optional = postProcessResultOrderRepository.findGuavaOptional(2L);
        assertEquals(optional.getClass().getSimpleName(), "Present");
    }

    @Test
    public void testFindJavaOptionalReturnsGuavaOptional() {
        java.util.Optional<Order> optional = postProcessResultOrderRepository.findJavaOptional(2L);
        assertEquals(optional.getClass(), java.util.Optional.class);
    }

    @Test
    public void testFindByIdExecutesAsynchronously() throws ExecutionException, InterruptedException {
        CompletableFuture<Order> completableFuture = postProcessResultOrderRepository.findByTitle("Funny Costume");
        assertFalse(completableFuture.isDone());
        assertEquals(1L, (long) completableFuture.get().getId());
    }
}

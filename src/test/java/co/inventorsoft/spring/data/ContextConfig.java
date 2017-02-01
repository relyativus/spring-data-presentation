package co.inventorsoft.spring.data;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestExecutionListeners;

/**
 * @author anatolii vakaliuk
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.inventorsoft.spring.data.repositories")
@EntityScan(basePackages = "co.inventorsoft.spring.data.model")
public class ContextConfig {

    public static void main(String[] args) {
        SpringApplication.run(ContextConfig.class, args);
    }
}

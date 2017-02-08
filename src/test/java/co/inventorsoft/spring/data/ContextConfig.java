package co.inventorsoft.spring.data;

import co.inventorsoft.spring.data.config.OptionalSupportJpaRepository;
import co.inventorsoft.spring.data.config.QueryExecutionTimeSupportRepositoryFactoryBean;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author anatolii vakaliuk
 */
@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "co.inventorsoft.spring.data.repositories",
        repositoryBaseClass = OptionalSupportJpaRepository.class,
        repositoryFactoryBeanClass = QueryExecutionTimeSupportRepositoryFactoryBean.class
)
@EnableJpaAuditing(auditorAwareRef = "simpleUserAuditorAware")
@EntityScan(basePackages = "co.inventorsoft.spring.data.model")
@EnableAsync
public class ContextConfig extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(ContextConfig.class, args);
    }


    @Override
    public Executor getAsyncExecutor() {
        return Executors.newFixedThreadPool(2);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

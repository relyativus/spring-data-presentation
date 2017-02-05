package co.inventorsoft.spring.data.config;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import javax.persistence.EntityManager;

/**
 * @author anatolii vakaliuk
 */
public class QueryExecutionTimePrinterSupportRepositoryFactory extends JpaRepositoryFactory {

    public QueryExecutionTimePrinterSupportRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        addRepositoryProxyPostProcessor((factory, repositoryInformation) -> factory.addAdvice(new QueryExecutionPrinterInterceptor()));
    }
}

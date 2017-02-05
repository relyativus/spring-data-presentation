package co.inventorsoft.spring.data.config;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * @author anatolii vakaliuk
 */
public class QueryExecutionTimeSupportRepositoryFactoryBean extends JpaRepositoryFactoryBean {

    private EntityManager entityManager;

    public QueryExecutionTimeSupportRepositoryFactoryBean(Class repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    protected RepositoryFactorySupport doCreateRepositoryFactory() {
        return new QueryExecutionTimePrinterSupportRepositoryFactory(entityManager);
    }


}

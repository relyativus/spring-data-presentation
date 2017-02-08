package co.inventorsoft.spring.data.config;

import co.inventorsoft.spring.data.repositories.OptionalSupportRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author anatolii vakaliuk
 */
public class OptionalSupportJpaRepository <E, ID extends Serializable>
        extends QueryDslJpaRepository<E, ID> implements OptionalSupportRepository<E, ID> {

    private EntityManager entityManager;

    public OptionalSupportJpaRepository(JpaEntityInformation<E, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Optional<E> findById(ID id) {
        E nullableEntity = entityManager.find(getDomainClass(), id);
        return Optional.ofNullable(nullableEntity);
    }
}

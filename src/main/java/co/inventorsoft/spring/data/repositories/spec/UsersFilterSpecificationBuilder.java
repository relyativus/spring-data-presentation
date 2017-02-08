package co.inventorsoft.spring.data.repositories.spec;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * @author anatolii vakaliuk
 */
public class UsersFilterSpecificationBuilder {
    private String firstName;
    private String lastName;

    public UsersFilterSpecificationBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UsersFilterSpecificationBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Specification<SimpleUser> build() {
        return (Root<SimpleUser> root,CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nonNull(firstName)) {
                predicates.add(cb.equal(root.<String>get("name"), cb.literal(firstName)));
            }

            if (nonNull(lastName)) {
                predicates.add(cb.equal(root.<String>get("lastName"), cb.literal(lastName)));
            }

            return predicates.stream()
                    .reduce(cb::or)
                    .orElseGet(() -> cb.equal(cb.literal(1), cb.literal(1)));
        };
    }


}

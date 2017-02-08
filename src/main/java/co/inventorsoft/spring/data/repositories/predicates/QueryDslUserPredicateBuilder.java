/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories.predicates;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.util.ArrayList;
import java.util.List;

import static co.inventorsoft.spring.data.model.QSimpleUser.simpleUser;
import static java.util.Objects.nonNull;

/**
 * @author anatolii
 */
public class QueryDslUserPredicateBuilder {
    private static final BooleanExpression NO_OP_PREDICATE = Expressions.ONE.eq(Expressions.ONE);

    private Long id;

    private String firstName;

    public QueryDslUserPredicateBuilder setId(final Long id) {
        this.id = id;
        return this;
    }

    public QueryDslUserPredicateBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Predicate build() {
        List<BooleanExpression> predicates = new ArrayList<>();
        if (nonNull(id)) {
            predicates.add(simpleUser.id.eq(id));
        }

        if (nonNull(firstName)) {
            predicates.add(simpleUser.firstName.contains(firstName));
        }

        return predicates.stream().reduce(Expressions::allOf).orElse(NO_OP_PREDICATE);
    }
}

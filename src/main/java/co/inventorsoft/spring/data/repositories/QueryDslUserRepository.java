/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

/**
 * @author anatolii
 */
public interface QueryDslUserRepository extends Repository<SimpleUser, Long>, QueryDslPredicateExecutor<SimpleUser> {
}

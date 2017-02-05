/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author anatolii
 */
public interface NativeQuerySupportRepository extends Repository<SimpleUser, Long> {

    @Query(value = "select su.* from simple_users su join orders o on o.user_id = su.id where su.id = :userId", nativeQuery = true)
    List<SimpleUser> findUsersNative(@Param("userId") long id);

    @Query(value = "SELECT su.id, su.first_name, COUNT(o.id)" +
            "FROM simple_users su LEFT JOIN orders o ON o.user_id=su.id GROUP BY su.id",
            nativeQuery = true)
    <T> List<T> findOrdersCountForUsers(Class<T> resultClass);
}

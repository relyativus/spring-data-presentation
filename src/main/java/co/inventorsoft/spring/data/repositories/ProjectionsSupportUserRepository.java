/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.UserInfo;
import co.inventorsoft.spring.data.model.SimpleUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author anatolii
 */
public interface ProjectionsSupportUserRepository extends CrudRepository<SimpleUser, Long> {

    @Query("select u.id as id, u.firstName as firstName, u.lastName as lastName from SimpleUser u where u.id = :userId")
    List<UserInfo> findById(@Param("userId") Long id);

    @Query("select u.id as id, u.firstName as firstName, u.lastName as lastName from SimpleUser u")
    Page<UserInfo> findOrderInfos(final Pageable pageable);
}

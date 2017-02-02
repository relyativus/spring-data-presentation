package co.inventorsoft.spring.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Simple user entity representation
 *
 * @author anatolii vakaliuk
 */
@NamedQuery(name = "findById", query = "SELECT u FROM SimpleUser u where u.id = :userId")
@Entity
@Table(name = "simple_users")
@Getter
@Setter
public class SimpleUser {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;
}

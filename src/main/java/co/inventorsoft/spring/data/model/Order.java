package co.inventorsoft.spring.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author anatolii vakaliuk
 */
@NamedQuery(name = "findOrderById", query = "select o from Order o where o.id = :orderId")
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public SimpleUser owner;
}

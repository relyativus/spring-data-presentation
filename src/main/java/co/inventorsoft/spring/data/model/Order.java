package co.inventorsoft.spring.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

/**
 * @author anatolii vakaliuk
 */
@NamedStoredProcedureQuery(name = "Order.binaryAdd", procedureName = "binaryAdd",
        parameters = {
                @StoredProcedureParameter(name = "arg1", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "arg2", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "result", mode = ParameterMode.OUT, type = Long.class)
        })
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

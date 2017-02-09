package co.inventorsoft.spring.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author anatolii vakaliuk
 */
@Entity
@Table(name = "auditable_users")
@Getter
@Setter
public class AuditableUser extends Auditable {

    private String name;
}

package co.inventorsoft.spring.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;

/**
 * @author anatolii vakaliuk
 */
@Entity
@Table(name = "auditable_pets")
@Getter
@Setter
public class AuditablePet extends Auditable {

    private String type;

    private String name;

    @CreatedBy
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private AuditableUser creator;

    @LastModifiedBy
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "updater_id")
    private AuditableUser updater;
}

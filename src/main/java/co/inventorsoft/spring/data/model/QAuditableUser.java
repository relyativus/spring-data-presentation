package co.inventorsoft.spring.data.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditableUser is a Querydsl query type for AuditableUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuditableUser extends EntityPathBase<AuditableUser> {

    private static final long serialVersionUID = -1038021581L;

    public static final QAuditableUser auditableUser = new QAuditableUser("auditableUser");

    public final QAuditable _super = new QAuditable(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DatePath<java.time.LocalDate> updatedAt = _super.updatedAt;

    public QAuditableUser(String variable) {
        super(AuditableUser.class, forVariable(variable));
    }

    public QAuditableUser(Path<? extends AuditableUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditableUser(PathMetadata metadata) {
        super(AuditableUser.class, metadata);
    }

}


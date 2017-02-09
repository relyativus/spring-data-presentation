package co.inventorsoft.spring.data.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuditablePet is a Querydsl query type for AuditablePet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuditablePet extends EntityPathBase<AuditablePet> {

    private static final long serialVersionUID = 1906172855L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuditablePet auditablePet = new QAuditablePet("auditablePet");

    public final QAuditable _super = new QAuditable(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final QAuditableUser creator;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    //inherited
    public final DatePath<java.time.LocalDate> updatedAt = _super.updatedAt;

    public final QAuditableUser updater;

    public QAuditablePet(String variable) {
        this(AuditablePet.class, forVariable(variable), INITS);
    }

    public QAuditablePet(Path<? extends AuditablePet> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuditablePet(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuditablePet(PathMetadata metadata, PathInits inits) {
        this(AuditablePet.class, metadata, inits);
    }

    public QAuditablePet(Class<? extends AuditablePet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new QAuditableUser(forProperty("creator")) : null;
        this.updater = inits.isInitialized("updater") ? new QAuditableUser(forProperty("updater")) : null;
    }

}


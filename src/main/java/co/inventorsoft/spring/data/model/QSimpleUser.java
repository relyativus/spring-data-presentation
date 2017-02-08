package co.inventorsoft.spring.data.model;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSimpleUser is a Querydsl query type for SimpleUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleUser extends EntityPathBase<SimpleUser> {

    private static final long serialVersionUID = -982600086L;

    public static final QSimpleUser simpleUser = new QSimpleUser("simpleUser");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final ListPath<Order, QOrder> orders = this.<Order, QOrder>createList("orders", Order.class, QOrder.class, PathInits.DIRECT2);

    public QSimpleUser(String variable) {
        super(SimpleUser.class, forVariable(variable));
    }

    public QSimpleUser(Path<? extends SimpleUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleUser(PathMetadata metadata) {
        super(SimpleUser.class, metadata);
    }

}


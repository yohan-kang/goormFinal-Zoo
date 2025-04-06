package zoo.insightnote.domain.insight.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInsight is a Querydsl query type for Insight
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInsight extends EntityPathBase<Insight> {

    private static final long serialVersionUID = 208724341L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInsight insight = new QInsight("insight");

    public final zoo.insightnote.global.entity.QBaseTimeEntity _super = new zoo.insightnote.global.entity.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isAnonymous = createBoolean("isAnonymous");

    public final BooleanPath isDraft = createBoolean("isDraft");

    public final BooleanPath isPublic = createBoolean("isPublic");

    public final StringPath memo = createString("memo");

    public final zoo.insightnote.domain.session.entity.QSession session;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final zoo.insightnote.domain.user.entity.QUser user;

    public final StringPath voteTitle = createString("voteTitle");

    public QInsight(String variable) {
        this(Insight.class, forVariable(variable), INITS);
    }

    public QInsight(Path<? extends Insight> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInsight(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInsight(PathMetadata metadata, PathInits inits) {
        this(Insight.class, metadata, inits);
    }

    public QInsight(Class<? extends Insight> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.session = inits.isInitialized("session") ? new zoo.insightnote.domain.session.entity.QSession(forProperty("session"), inits.get("session")) : null;
        this.user = inits.isInitialized("user") ? new zoo.insightnote.domain.user.entity.QUser(forProperty("user")) : null;
    }

}


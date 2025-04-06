package zoo.insightnote.domain.InsightLike.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInsightLike is a Querydsl query type for InsightLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInsightLike extends EntityPathBase<InsightLike> {

    private static final long serialVersionUID = 1971014837L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInsightLike insightLike = new QInsightLike("insightLike");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final zoo.insightnote.domain.insight.entity.QInsight insight;

    public final zoo.insightnote.domain.user.entity.QUser user;

    public QInsightLike(String variable) {
        this(InsightLike.class, forVariable(variable), INITS);
    }

    public QInsightLike(Path<? extends InsightLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInsightLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInsightLike(PathMetadata metadata, PathInits inits) {
        this(InsightLike.class, metadata, inits);
    }

    public QInsightLike(Class<? extends InsightLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.insight = inits.isInitialized("insight") ? new zoo.insightnote.domain.insight.entity.QInsight(forProperty("insight"), inits.get("insight")) : null;
        this.user = inits.isInitialized("user") ? new zoo.insightnote.domain.user.entity.QUser(forProperty("user")) : null;
    }

}


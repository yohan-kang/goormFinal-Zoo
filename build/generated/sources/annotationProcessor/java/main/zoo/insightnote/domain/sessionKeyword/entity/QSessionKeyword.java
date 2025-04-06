package zoo.insightnote.domain.sessionKeyword.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSessionKeyword is a Querydsl query type for SessionKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSessionKeyword extends EntityPathBase<SessionKeyword> {

    private static final long serialVersionUID = -901161163L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSessionKeyword sessionKeyword = new QSessionKeyword("sessionKeyword");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final zoo.insightnote.domain.keyword.entity.QKeyword keyword;

    public final zoo.insightnote.domain.session.entity.QSession session;

    public QSessionKeyword(String variable) {
        this(SessionKeyword.class, forVariable(variable), INITS);
    }

    public QSessionKeyword(Path<? extends SessionKeyword> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSessionKeyword(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSessionKeyword(PathMetadata metadata, PathInits inits) {
        this(SessionKeyword.class, metadata, inits);
    }

    public QSessionKeyword(Class<? extends SessionKeyword> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.keyword = inits.isInitialized("keyword") ? new zoo.insightnote.domain.keyword.entity.QKeyword(forProperty("keyword")) : null;
        this.session = inits.isInitialized("session") ? new zoo.insightnote.domain.session.entity.QSession(forProperty("session"), inits.get("session")) : null;
    }

}


package zoo.insightnote.domain.userIntroductionLink.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserIntroductionLink is a Querydsl query type for UserIntroductionLink
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserIntroductionLink extends EntityPathBase<UserIntroductionLink> {

    private static final long serialVersionUID = 1653343117L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserIntroductionLink userIntroductionLink = new QUserIntroductionLink("userIntroductionLink");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath linkUrl = createString("linkUrl");

    public final zoo.insightnote.domain.user.entity.QUser user;

    public QUserIntroductionLink(String variable) {
        this(UserIntroductionLink.class, forVariable(variable), INITS);
    }

    public QUserIntroductionLink(Path<? extends UserIntroductionLink> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserIntroductionLink(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserIntroductionLink(PathMetadata metadata, PathInits inits) {
        this(UserIntroductionLink.class, metadata, inits);
    }

    public QUserIntroductionLink(Class<? extends UserIntroductionLink> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new zoo.insightnote.domain.user.entity.QUser(forProperty("user")) : null;
    }

}


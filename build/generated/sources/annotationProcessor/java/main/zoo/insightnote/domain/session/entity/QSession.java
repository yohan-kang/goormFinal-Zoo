package zoo.insightnote.domain.session.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSession is a Querydsl query type for Session
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSession extends EntityPathBase<Session> {

    private static final long serialVersionUID = 1526089141L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSession session = new QSession("session");

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final zoo.insightnote.domain.event.entity.QEvent event;

    public final DatePath<java.time.LocalDate> eventDay = createDate("eventDay", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final StringPath longDescription = createString("longDescription");

    public final NumberPath<Integer> maxCapacity = createNumber("maxCapacity", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> participantCount = createNumber("participantCount", Integer.class);

    public final StringPath shortDescription = createString("shortDescription");

    public final zoo.insightnote.domain.speaker.entity.QSpeaker speaker;

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final EnumPath<SessionStatus> status = createEnum("status", SessionStatus.class);

    public final StringPath videoLink = createString("videoLink");

    public QSession(String variable) {
        this(Session.class, forVariable(variable), INITS);
    }

    public QSession(Path<? extends Session> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSession(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSession(PathMetadata metadata, PathInits inits) {
        this(Session.class, metadata, inits);
    }

    public QSession(Class<? extends Session> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.event = inits.isInitialized("event") ? new zoo.insightnote.domain.event.entity.QEvent(forProperty("event")) : null;
        this.speaker = inits.isInitialized("speaker") ? new zoo.insightnote.domain.speaker.entity.QSpeaker(forProperty("speaker")) : null;
    }

}


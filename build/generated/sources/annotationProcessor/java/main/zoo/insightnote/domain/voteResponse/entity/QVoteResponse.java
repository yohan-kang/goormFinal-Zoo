package zoo.insightnote.domain.voteResponse.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVoteResponse is a Querydsl query type for VoteResponse
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVoteResponse extends EntityPathBase<VoteResponse> {

    private static final long serialVersionUID = 1485333989L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVoteResponse voteResponse = new QVoteResponse("voteResponse");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final zoo.insightnote.domain.user.entity.QUser user;

    public final DateTimePath<java.time.LocalDateTime> votedAt = createDateTime("votedAt", java.time.LocalDateTime.class);

    public final zoo.insightnote.domain.voteOption.entity.QVoteOption voteOption;

    public QVoteResponse(String variable) {
        this(VoteResponse.class, forVariable(variable), INITS);
    }

    public QVoteResponse(Path<? extends VoteResponse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVoteResponse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVoteResponse(PathMetadata metadata, PathInits inits) {
        this(VoteResponse.class, metadata, inits);
    }

    public QVoteResponse(Class<? extends VoteResponse> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new zoo.insightnote.domain.user.entity.QUser(forProperty("user")) : null;
        this.voteOption = inits.isInitialized("voteOption") ? new zoo.insightnote.domain.voteOption.entity.QVoteOption(forProperty("voteOption"), inits.get("voteOption")) : null;
    }

}


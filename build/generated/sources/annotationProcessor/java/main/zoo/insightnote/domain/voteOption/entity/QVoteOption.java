package zoo.insightnote.domain.voteOption.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVoteOption is a Querydsl query type for VoteOption
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVoteOption extends EntityPathBase<VoteOption> {

    private static final long serialVersionUID = -1601425075L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVoteOption voteOption = new QVoteOption("voteOption");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final zoo.insightnote.domain.insight.entity.QInsight insight;

    public final StringPath optionText = createString("optionText");

    public QVoteOption(String variable) {
        this(VoteOption.class, forVariable(variable), INITS);
    }

    public QVoteOption(Path<? extends VoteOption> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVoteOption(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVoteOption(PathMetadata metadata, PathInits inits) {
        this(VoteOption.class, metadata, inits);
    }

    public QVoteOption(Class<? extends VoteOption> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.insight = inits.isInitialized("insight") ? new zoo.insightnote.domain.insight.entity.QInsight(forProperty("insight"), inits.get("insight")) : null;
    }

}


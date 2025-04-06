package zoo.insightnote.domain.speaker.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSpeaker is a Querydsl query type for Speaker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSpeaker extends EntityPathBase<Speaker> {

    private static final long serialVersionUID = -1082874219L;

    public static final QSpeaker speaker = new QSpeaker("speaker");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath position = createString("position");

    public QSpeaker(String variable) {
        super(Speaker.class, forVariable(variable));
    }

    public QSpeaker(Path<? extends Speaker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpeaker(PathMetadata metadata) {
        super(Speaker.class, metadata);
    }

}


package zoo.insightnote.domain.insight.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLatestInsightImage is a Querydsl query type for LatestInsightImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLatestInsightImage extends EntityPathBase<LatestInsightImage> {

    private static final long serialVersionUID = 933546957L;

    public static final QLatestInsightImage latestInsightImage = new QLatestInsightImage("latestInsightImage");

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final StringPath fileUrl = createString("fileUrl");

    public QLatestInsightImage(String variable) {
        super(LatestInsightImage.class, forVariable(variable));
    }

    public QLatestInsightImage(Path<? extends LatestInsightImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLatestInsightImage(PathMetadata metadata) {
        super(LatestInsightImage.class, metadata);
    }

}


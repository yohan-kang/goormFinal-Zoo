package zoo.insightnote.domain.insight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zoo.insightnote.domain.insight.dto.request.InsightCreateRequest;
import zoo.insightnote.domain.insight.dto.request.InsightUpdateRequest;
import zoo.insightnote.domain.session.entity.Session;
import zoo.insightnote.domain.user.entity.User;
import zoo.insightnote.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Insight extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String memo;

    @Column(nullable = false)
    private Boolean isPublic;

    @Column(nullable = false)
    private Boolean isAnonymous;

    @Column(nullable = false)
    private Boolean isDraft;

    @Column(nullable = true)
    private String voteTitle;

    @Builder
    public Insight(Session session, User user, String memo, Boolean isPublic, Boolean isAnonymous, Boolean isDraft, String voteTitle) {
        this.session = session;
        this.user = user;
        this.memo = memo;
        this.isPublic = isPublic != null ? isPublic : true;
        this.isAnonymous = isAnonymous != null ? isAnonymous : true;
        this.isDraft = isDraft != null ? isDraft : false;
        this.voteTitle = voteTitle;
    }

    public static Insight create(Session session, User user, InsightCreateRequest request) {
        return Insight.builder()
                .session(session)
                .user(user)
                .memo(request.memo())
                .isPublic(request.isPublic())
                .isAnonymous(request.isAnonymous())
                .isDraft(request.isDraft())
//                .voteTitle(voteTitle)
                .build();
    }

    //  익명 여부에 따라 이름 반환
    public String getDisplayName() {
        return isAnonymous ? user.getNickname() : user.getName();
    }

    // 업데이트 로직 (익명 여부 포함)
    public void updateIfChanged(InsightUpdateRequest request) {
        if (request.memo() != null && !request.memo().equals(this.memo)) {
            this.memo = request.memo();
        }
        if (request.isPublic() != null && !request.isPublic().equals(this.isPublic)) {
            this.isPublic = request.isPublic();
        }
        if (request.isAnonymous() != null && !request.isAnonymous().equals(this.isAnonymous)) {
            this.isAnonymous = request.isAnonymous();
        }
        if (request.isDraft() != null && !request.isDraft().equals(this.isDraft)) {
            this.isDraft = request.isDraft();
        }
    }

    public void finalizeDraft() {
        this.isDraft = false;
    }


}

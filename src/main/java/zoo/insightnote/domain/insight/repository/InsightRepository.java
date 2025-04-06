package zoo.insightnote.domain.insight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zoo.insightnote.domain.insight.entity.Insight;
import zoo.insightnote.domain.session.entity.Session;
import zoo.insightnote.domain.user.entity.User;

import java.util.Optional;


public interface InsightRepository extends JpaRepository<Insight, Long>, InsightQueryRepository {
    Optional<Insight> findBySessionAndUser(Session session, User user);

}

package zoo.insightnote.domain.keyword.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zoo.insightnote.domain.keyword.entity.Keyword;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Optional<Keyword> findByName(String name);
}
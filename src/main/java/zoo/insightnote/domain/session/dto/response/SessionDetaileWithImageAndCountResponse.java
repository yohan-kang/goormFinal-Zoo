package zoo.insightnote.domain.session.dto.response;

import java.time.LocalDateTime;
import java.util.Set;


public record SessionDetaileWithImageAndCountResponse(
        Long id,
        String name,
        String shortDescription,
        String location,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String timeRange,
        Integer participantCount,
        Integer maxCapacity,
        Set<String> keywords,
        String speakerImageUrl,
        String speakerName
) {}

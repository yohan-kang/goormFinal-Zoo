package zoo.insightnote.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    @Value("${FRONT_URL}")
    private String frontUrl;

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://localhost:3000",
                        "https://www.synapsex.online",
                        "http://www.synapsex.online",
                        "http://api.synapsex.online",
                        "https://api.synapsex.online",
                        "http://dev.synapsex.online",
                        "https://dev.synapsex.online") // 특정 Origin만 허용해야 함
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true) // 쿠키 허용 설정 추가
                .exposedHeaders("Set-Cookie");
    }
}

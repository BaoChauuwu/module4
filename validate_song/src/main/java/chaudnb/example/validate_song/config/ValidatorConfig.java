package chaudnb.example.validate_song.config;

import chaudnb.example.validate_song.validation.SongValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {
    
    @Bean
    public SongValidator songValidator() {
        return new SongValidator();
    }
}

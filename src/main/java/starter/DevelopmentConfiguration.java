package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevelopmentConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    @Bean
    public DevelopmentDataLoader dataLoader() {
        return new DevelopmentDataLoader();
    }

}

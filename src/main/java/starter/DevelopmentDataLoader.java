package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class DevelopmentDataLoader implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentDataLoader.class);

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Initialising database for development mode...");

        LOG.info("... nothing.");
    }
}

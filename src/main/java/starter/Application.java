package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import frontend.FrontendConfiguration;
import repository.RepositoryConfiguration;
import service.ServiceConfiguration;

@SpringBootApplication(scanBasePackageClasses = { DevelopmentConfiguration.class, ServiceConfiguration.class,
		FrontendConfiguration.class, RepositoryConfiguration.class })
@EnableScheduling
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			// LOG.info("Let's inspect the beans provided by Spring Boot:");
			//
			// String[] beanNames = ctx.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// LOG.info(beanName);
			// }

		};
	}

}

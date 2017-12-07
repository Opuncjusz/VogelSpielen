package test;

import org.springframework.context.annotation.ComponentScan;

import frontend.FrontendConfiguration;
import repository.RepositoryConfiguration;
import service.ServiceConfiguration;

@ComponentScan(basePackageClasses = { ServiceConfiguration.class, FrontendConfiguration.class,
		RepositoryConfiguration.class })

public class TestApplicationContext {
}

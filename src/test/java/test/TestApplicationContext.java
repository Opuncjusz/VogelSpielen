package test;

import org.springframework.context.annotation.ComponentScan;

import frontend.FrontendConfiguration;
import service.ServiceConfiguration;


@ComponentScan(basePackageClasses = { ServiceConfiguration.class, FrontendConfiguration.class})
public class TestApplicationContext {
}

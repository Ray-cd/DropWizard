package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.health.TemplateHealthCheck;
import org.example.resources.HelloWorldResource;

/**
 * Hello world!
 *
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception{
        if(args.length>0)
        new HelloWorldApplication().run(args);
        else{
            new HelloWorldApplication().run(new String[]{"server","config.yml"});
        }
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //TBD
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(),
                helloWorldConfiguration.getDefaultName()
        );
        final TemplateHealthCheck template_check = new TemplateHealthCheck(helloWorldConfiguration.getTemplate());
        environment.healthChecks().register("template",template_check);
        environment.jersey().register(resource);
    }
}

package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.EmployeeController;

public class DropwizardwebserviceApplication extends Application<DropwizardwebserviceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardwebserviceApplication().run(args);
    }

    @Override
    public String getName() {
        return "Dropwizardwebservice";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardwebserviceConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new SwaggerBundle<DropwizardwebserviceConfiguration>() {

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropwizardwebserviceConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final DropwizardwebserviceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new EmployeeController());
    }




}
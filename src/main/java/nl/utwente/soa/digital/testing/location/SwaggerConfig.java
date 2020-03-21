package nl.utwente.soa.digital.testing.location;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**
 * Configure the swagger api, can be found at http://localhost:8080/swagger-ui.html
 */
public class SwaggerConfig {
    @Bean
    public Docket OrderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("nl.utwente.soa.digital.testing.location.rest"))
                .paths(PathSelectors.any())
                .build();
    }
}
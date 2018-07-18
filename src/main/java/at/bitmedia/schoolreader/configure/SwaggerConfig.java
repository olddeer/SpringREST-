package at.bitmedia.schoolreader.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.err401.message}")
    private String message401;
    @Value("${swagger.err406.message}")
    private String message406;
    @Value("${swagger.err500.message}")
    private String message500;
    @Value("${swagger.url}")
    private String hostUrl;
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.scope.read}")
    private String readScope;
    @Value("${swagger.scope.write}")
    private String writeScope;

    @Bean
    public Docket api() {
        List<ResponseMessage> list = new java.util.ArrayList<>();
        list.add(new ResponseMessageBuilder().code(500).message(message500)
            .responseModel(new ModelRef("Result")).build());
        list.add(new ResponseMessageBuilder().code(401).message(message401)
            .responseModel(new ModelRef("Result")).build());
        list.add(new ResponseMessageBuilder().code(406).message(message406)
            .responseModel(new ModelRef("Result")).build());
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build().securitySchemes(Arrays.asList(securityScheme()))
            .securityContexts(Arrays.asList(securityContext())).useDefaultResponseMessages(false).apiInfo(apiInfo())
            .globalResponseMessage(RequestMethod.GET, list)
            .globalResponseMessage(RequestMethod.POST, list);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description)
            .license("Open Source").version("1.0.0").build();
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
            new AuthorizationScope("read", "for read operations"),
            new AuthorizationScope("write", "for write operations")};
        return scopes;
    }

    private springfox.documentation.spi.service.contexts.SecurityContext securityContext() {
        return springfox.documentation.spi.service.contexts.SecurityContext.builder()
            .securityReferences(
                Arrays.asList(new SecurityReference("spring_oauth", scopes())))
            .forPaths(PathSelectors.regex("/*"))
            .build();
    }

    private SecurityScheme securityScheme() {

        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant(hostUrl + "/oauth/token");

        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
            .grantTypes(Arrays.asList(creGrant))
            .scopes(Arrays.asList(scopes()))
            .build();
        return oauth;
    }
}
package org.accenture.api.pruebaApi.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SECURITY_SCHEME = "bearer";
    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    private static final String INFO_TERMS = "http://swagger.io/terms/";
    private static final String INFO_DESCRIPTION = "OpenAPI 3 Documentation";
    private static final String LICENSE_URL = "https://portalzonaser.mutualser.com/";
    private static final String LICENSE_NAME = "No License";

    @Bean
    public OpenAPI openAPI(@Value("${spring.application.name}") String title, @Value("${spring.application.version}") String version) {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(
                        new Components()
                                .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                        new SecurityScheme()
                                                .name(SECURITY_SCHEME_NAME)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme(SECURITY_SCHEME)
                                                .bearerFormat(BEARER_FORMAT)
                                )
                )
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(INFO_DESCRIPTION)
                        .termsOfService(INFO_TERMS)
                        .license(new License()
                                .name(LICENSE_NAME)
                                .url(LICENSE_URL)));
    }
}
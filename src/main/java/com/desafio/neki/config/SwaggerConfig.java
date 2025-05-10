package com.desafio.neki.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NEKI API")
                        .description("Desafio Neki \n\n" +
                                "**GitHub**: [cintra444](https://github.com/cintra444)\n\n" +
                                "**LinkedIn**: [Eber Cintra](https://www.linkedin.com/in/ebercintra)\n\n" +
                                "**Portfólio**: [Portfólio Eber](https://portifolio-eber.netlify.app/#portifolio)\n\n")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Eber Cintra")
                                .email("cintra.eber@gmail.com")
                                .url("https://www.linkedin.com/in/ebercintra/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")
                        ))

                        .addSecurityItem(new SecurityRequirement().addList("Bearer"))
                        .components(new Components()
                                .addSecuritySchemes("Bearer",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                        );
    }
}

package de.smartcity.ngsiserver;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NGSI-LD Parking Server")
                        .version("1.0")
                        .description("Smart Cities SoSe 2026 – NGSI-LD API für Parkplatzdaten"));
    }
}
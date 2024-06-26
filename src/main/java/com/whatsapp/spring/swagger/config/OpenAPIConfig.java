package com.whatsapp.spring.swagger.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Value("${whatsapp.openapi.dev-url}")
    private String devUrl;

    @Value("${whatsapp.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("meretsolomon@gmail.com");
        contact.setName("Developer");
        contact.setUrl("https://www.linkedin.com/in/muluken-solomon-9277b3118/");
//
        License mitLicense = new License().name("Github source code").url("https://github.com/muletasolomon/whatsup-chatroom");

        Info info = new Info()
                .title("WhatsApp API server")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage whatsapp server.").termsOfService("https://github.com/muletasolomon/whatsup-chatroom")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}

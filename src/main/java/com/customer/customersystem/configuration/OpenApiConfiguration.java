package com.customer.customersystem.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer System API")
                        .version("1")
                        .description("API para cadastro de clientes")
                        .contact(contact()));
    }

    private Contact contact() {
        var contact = new Contact();
        contact.setName("Maycon Carvalho");
        contact.setUrl("https://www.linkedin.com/in/mayconcarvalhodev/");
        contact.setEmail("maycon.carvalho.dev@gmail.com");
        return contact;
    }

}

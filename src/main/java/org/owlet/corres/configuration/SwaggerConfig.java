package org.owlet.corres.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
    public Docket docket() {
    	System.out.println("docket");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                           
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
	
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
                .title("Correspondence ACL API")
                .description("Correspondence ACL API.")
                .termsOfServiceUrl("http://springfox.io")
                .contact(apiContact())
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
    
    private Contact apiContact() {    	
    	Contact contact = new Contact("Pong", "http://github.com/pizza-hut", "soon_lung_pong@manulife.com");
    	return contact;
    }

}

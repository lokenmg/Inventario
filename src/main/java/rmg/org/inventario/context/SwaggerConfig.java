///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package rmg.org.inventario.context;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import java.util.Collections;
///**
// *
// * @author loken
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    
//    @Bean
//	public Docket apiDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("rmg.org.inventario.controller"))
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo(getApiInfo())
//				;
//	}
//        
//        	private ApiInfo getApiInfo() {
//		return new ApiInfo(
//				"Order Service API",
//				"Order Service API Description",
//				"1.0",
//				"http://example.com/terms",
//				new Contact("Codmind", "https://example.com", "apis@example.com"),
//				"LICENSE",
//				"LICENSE URL",
//				Collections.emptyList()
//				);
//	}
//}

package com.example.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.Arrays;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}
}

@RestController
class ProductController {
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");
        return resolver;
    }

	@GetMapping(path = "/products")
	public String getProducts(Principal principal,Model model){
		model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
		return "productPage:"+principal.getName();
	}

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/";
	}
}

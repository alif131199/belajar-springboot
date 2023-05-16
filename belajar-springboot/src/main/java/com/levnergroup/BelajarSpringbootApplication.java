package com.levnergroup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.levnergroup.entity.Product;
import com.levnergroup.service.ProductService;

@SpringBootApplication
public class BelajarSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringbootApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(ProductService productService){
		return args -> {
			productService.addProduct(new Product(1L,"BAG001","Tas Toiza",100000.00));
			productService.addProduct(new Product(2L,"BAG002","Tas Briza",170000.00));
			productService.addProduct(new Product(3L,"PEN001","Kakada Pen",10000.00));
			productService.addProduct(new Product(4L,"PCH001","Pouch Nexa",75000.00));
			productService.addProduct(new Product(5L,"PCH002","Pouch Tela",88000.00));
			productService.addProduct(new Product(6L,"GDT001","Speaker",130000.00));
		};
	}
}

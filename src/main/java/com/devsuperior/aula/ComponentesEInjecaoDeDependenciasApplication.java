package com.devsuperior.aula;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class ComponentesEInjecaoDeDependenciasApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentesEInjecaoDeDependenciasApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("ENTRADA (dados do pedido: código, valor básico, porcentagem de desconto)");
		
		int code = sc.nextInt();
		
		double basic = sc.nextDouble();
		
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		double total = orderService.total(order);
		
		System.out.println();		
		
		System.out.println(order.toString());
		
		System.out.printf("Valor total: R$ %.2f ", total);		
		
		sc.close();
	}
}

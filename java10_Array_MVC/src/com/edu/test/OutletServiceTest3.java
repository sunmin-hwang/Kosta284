package com.edu.test;

import com.edu.service.OutletService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletServiceTest3 {

	public static void main(String[] args) {
		Product[] products1 = {
				new Product("신라면", 1200, 5, "농심"),
				new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "엘지"),
				new Product("짐빔", 130000, 1, "JIM")
		};
		
		Product[] products2 = {
				new Product("Terra", 2200, 1, "농심"),
				new Product("맥심커피", 20000, 1, "농심"),
				new Product("휘센 에어컨", 3340000, 1, "대우")
		};
		
		
		Customer c1 = new Customer(111, "이정재", "방배동");
		Customer c2 = new Customer(222, "정우성", "신사동");
		Customer c3 = new Customer(333, "제니", "방배동");
		c1.buyProducts(products1);
		c2.buyProducts(products2);
		
		Customer[] customers = {c1, c2, c3};
		
		OutletService service = new OutletService();
		Product[] pros = service.getAllProduct(customers[0]);
		String[] makers = service.getAllProductMaker(customers[1]);
		Customer cus = service.findCustomer(customers, 111);
		Customer[] custo = service.findCustomer(customers, "신사동");
		
		for(Product product : pros) System.out.println(product.getDetails());
		for(String maker: makers) System.out.println(maker);
		System.out.println(cus.getCustomerInfo());
		System.out.println(service.maxPrice(customers[1]));
		for(Customer customer: custo) System.out.println(customer.getCustomerInfo());
	}

}

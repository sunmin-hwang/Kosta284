package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

//Outlet에서 상품을 구매하는 고객의 기능을 정의하고 있는 클래스...
//서비스 클래스는 기능만으로 이뤄지는 클래스(DAO)
//vo, test, service 클래스를 작성하게 되면 드디어 구조적인 Application을 자바 SE기반으로 작성
public class OutletService {
	//1. 특정 고객이 구입한 상품을 반환하는 기능
	public Product[] getAllProduct(Customer customer) {
		return customer.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품의 MAKER들만을 반환하는 기능
	public String[] getAllProductMaker(Customer customer) {
		Product[] pros = customer.getProducts();
		String[] temp = new String[pros.length];
		for(int i = 0 ; i < pros.length ; i++) {
			temp[i] = pros[i].getMaker();
		}
		return temp;
	}
	
	//3. Outlet안에 있는 고객중에서 특정한 고객을 검색하는 기능
	//메소드 오버로딩 : 하는 일은 같지만 처리하는 데이터를 달리할 때 쓰는 기법
	//RULE 1 : 메소드 이름 동일
	//     2 : 인자값 다름
	//     3 : 리턴타입 상관없음
	//서비스 클래스에서 기능의 일관성을 보장하는 아주 중요한 기법
	public Customer findCustomer(Customer[] customers, int ssn) {
		Customer customer = null;
		for(Customer cus : customers) {
			if(cus.getSsn() == ssn) customer = cus;
		}
		return customer;
	}
	
	//4. Outlet안에 있는 고객중에서 동일한 주소를 가지소 있는 고객들을 반환
	public Customer[] findCustomer(Customer[] customers, String address) {
		Customer[] temp = new Customer[customers.length];
		int idx = 0;
		for(Customer cus : customers) {
			if(cus.getAddress().equals(address)) temp[idx++] = cus;
		}
		Customer[] addrCustomers = new Customer[idx];
		System.arraycopy(temp, 0, addrCustomers, 0, addrCustomers.length);
		return addrCustomers;
	}
	
	//5. 특정 고객이 구입한 물건중에서 최고가게 해당하는 물건의 가격을 리턴하는 기능
	public int maxPrice(Customer customer) {
		Product[] products = customer.getProducts();
		int max = products[0].getPrice();
		for(Product product: products) {
			if(product.getPrice() >= max) max = product.getPrice();
		}
		return max;
	}
	
	//6. 모든 고객이 구입한 물건중 특정 가격 이상이 되는 제품들을 반환하는 기능
	public Product[] getMorePriceProduct(Customer[] customers, int price) {
		int size = 0;
		for(Customer c : customers) {
			if(c.getProducts() !=null)
				size += c.getProducts().length;
		}
		
		Product[] temp = new Product[size];
		int idx = 0;
		//상품을 구매하지않은 제니를 위한 구문
		for(Customer c : customers) {
			if(c.getProducts() == null) continue;
			
			for(Product p : c.getProducts()) {
				if( p.getPrice() >= price)
					temp[idx++] = p;
			}
		}
		
		return temp;
	}
}

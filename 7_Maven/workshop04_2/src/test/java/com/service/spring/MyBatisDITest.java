package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

public class MyBatisDITest {
	//myBatis와  DI연동 부분의 단위테스트...빈 설정문서를 읽어야 한다.
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/bean/beans.xml");
	@Test
	public void addTest() throws Exception{			
		
		//IOC로부터 MyProductDAO, MyProductService 객체를 반환
		MyProductDAO dao=(MyProductDAO)factory.getBean("myProductDAO");
		
		
		MyProduct pvo = new MyProduct("공기청정기", "LG", 1000000);
		System.out.println("--------------------1. add--------------------");
		dao.addProduct(pvo);//sqlSession의 insert()호출 --> 디비작업..
	}
	
	@Test
	public void findTest() throws Exception{
		MyProductService service=(MyProductService)factory.getBean("myProductService");
		System.out.println("--------------------2. findProductByName--------------------");
		List<MyProduct> list1=service.findProductByName("세탁기");
		for(MyProduct p : list1)
			System.out.println(p);
		
		System.out.println("--------------------3. findProductByName--------------------");
		List<MyProduct> list2=service.findProductByMaker("LG");
		for(MyProduct p : list2)
			System.out.println(p);
		
		System.out.println("--------------------4. findProducts--------------------");
		List<MyProduct> list3=service.findProducts();
		for(MyProduct p : list3)
			System.out.println(p);
		
	}
}













package com.services.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.MyProduct;
import com.services.spring.dao.MyProductDAO;
import com.services.spring.service.MyProductService;

public class MyBatisDITest {
	ApplicationContext factory = new ClassPathXmlApplicationContext("/bean/beans.xml");

	//myBatis와 DI연동 부분의 단위테스트...빈 설정문서를 읽어야 한다.
	@Test
	public void addTest() throws Exception{
		//IOC로부터 MyProductDAO 객체를 반환
		MyProductDAO dao = (MyProductDAO)factory.getBean("myProductDAO");
		MyProductService service = (MyProductService)factory.getBean("myProductService");
		MyProduct pvo = new MyProduct("공기청정기", "LG", 1000000);
		service.addProduct(pvo);
	}
	
	@Test
	public void findTest() throws Exception{
		MyProductService service = (MyProductService)factory.getBean("myProductService");
		List<MyProduct> list = service.findProductByName("세탁기");
		for(MyProduct p : list) System.out.println(p);
		
		list = service.findProductByMaker("LG");
		for(MyProduct p : list) System.out.println(p);
		
		list = service.findProducts();
		for(MyProduct p : list) System.out.println(p);
	}
}

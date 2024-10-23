package com.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Phone;
import com.service.spring.service.PhoneService;

public class DIUnitTest {
	
	String[] beans = new String[] {
		"/beans/businessBean.xml",
		"/beans/presentationBean.xml"
	};
	
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext(beans);
	PhoneService service = (PhoneService)factory.getBean("phoneService");
	
	@Test
	public void insert() throws Exception{
		Phone p1 = new Phone("IPO16", "iPhone16 PRO", 3650000, "30");
		service.insert(p1);
		
		Phone p2 = new Phone("IPO17", "iPhone17", 2450000, "30");
		service.insert(p2);
	}
	
	@Test
	public void select() throws Exception{
		
		List<Phone> list = service.select();
		for(Phone p : list)
			System.out.println(p);
		
		System.out.println("======================================s");
		
		Phone vo = new Phone();
		vo.setNum("IPO16");
		
		Phone rvo = service.select(vo);
		System.out.println(rvo);
	}
	
	@Test
	public void delete() throws Exception{
		List<String> nums = new ArrayList<String>();
		nums.add("IPO16");
		nums.add("IPO17");
		System.out.println(service.delete(nums));
	}
	
	@Test
	public void update() throws Exception{
		System.out.println(service.update(new Phone("IPO16", "iPhone16", 1650000, "30")));
	}
}

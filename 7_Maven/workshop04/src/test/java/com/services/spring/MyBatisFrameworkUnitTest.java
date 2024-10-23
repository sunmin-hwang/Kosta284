package com.services.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkUnitTest {
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		session.insert("ns.sql.MyProductMapper.addProduct", new MyProduct(0, "드럼 세탁기", "SAMSUNG", 270000));
		session.insert("ns.sql.MyProductMapper.addProduct", new MyProduct(0, "통돌이 세탁기", "LG", 350000));
		session.insert("ns.sql.MyProductMapper.addProduct", new MyProduct(0, "아주 좋은 에어컨", "SAMSUNG", 530000));
		session.insert("ns.sql.MyProductMapper.addProduct", new MyProduct(0, "이것이 바로 세탁기", "SAMSUNG", 430000));
		session.commit();
		
		List<MyProduct> list = session.selectList("ns.sql.MyProductMapper.findProducts");
		for(MyProduct p : list) {
			System.out.println(p);
		}
		
		System.out.println("==============================================");
		
		list = session.selectList("ns.sql.MyProductMapper.findProductByName", "세탁기");
		for(MyProduct p : list) {
			System.out.println(p);
		}
		
		System.out.println("==============================================");
		
		list = session.selectList("ns.sql.MyProductMapper.findProductByMaker", "SAMSUNG");
		for(MyProduct p : list) {
			System.out.println(p);
		}
	}
}

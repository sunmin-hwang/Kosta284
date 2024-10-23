package com.service.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Book;

public class MyBatisBookUnitTest {
	@Test
	public void loginTest() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		List<Book> list = session.selectList("ns.sql.BookMapper.searchByTitle", "하하");
		for(Book b : list)
			System.out.println(b);
		
		System.out.println("-----------------------------------");
		
		list = session.selectList("ns.sql.BookMapper.searchByPrice", "12345");
		for(Book b : list)
			System.out.println(b);
	}
}

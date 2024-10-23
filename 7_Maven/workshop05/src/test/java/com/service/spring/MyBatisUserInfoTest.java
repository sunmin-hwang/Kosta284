package com.service.spring;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.User;

public class MyBatisUserInfoTest {
	@Test
	public void loginTest() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		User pvo = new User();
		pvo.setUserId("kosta");
		System.out.println((User)session.selectOne("ns.sql.UserMapper.getUser", pvo));
		
		System.out.println("-----------------------------------");
		
		pvo.setPassword("1234");
		System.out.println((User)session.selectOne("ns.sql.UserMapper.getUser", pvo));
		
		System.out.println("-----------------------------------");
		
		User pvo1 = new User("ssss", "mmmm", "sm", "smsm@naver.com");
		session.insert("ns.sql.UserMapper.addUser", pvo1);
		session.commit();
	}
}

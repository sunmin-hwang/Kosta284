package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;

public class MyBatisJUnitTest02 {
	
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		//쿼리문 실행
		List<Item> list = session.selectList("ns.sql.FruitMapper.getItemList");
		for(Item i : list) {
			System.out.println(i);
		}
		
		System.out.println("=====================================================");
		
		Item item = session.selectOne("ns.sql.FruitMapper.getItem", 1111);
		System.out.println(item);
	}
}

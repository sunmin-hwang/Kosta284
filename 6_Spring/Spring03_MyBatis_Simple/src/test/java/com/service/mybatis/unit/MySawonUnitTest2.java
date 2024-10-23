package com.service.mybatis.unit;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MySawonUnitTest2 {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory = FactoryService.getFactory();
		
		//3. SqlSession 생성...
		SqlSession session = factory.openSession();

		session.selectList("SawonMapper.sawonList").forEach(c->System.out.println(c));
		session.close();
	}
}

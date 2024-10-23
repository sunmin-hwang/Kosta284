package com.services.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAO {
	public static final String NS = "ns.sql.MyProductMapper.";
	@Autowired
	SqlSession sqlSession;
	
	public void addProduct(MyProduct myProduct) throws Exception{
		sqlSession.insert(NS + "addProduct", myProduct);
	}
	
	public List<MyProduct> findProductByName(String name) throws Exception{
		return sqlSession.selectList(NS + "findProductByName", name);
	}
	
	public List<MyProduct> findProductByMaker(String maker) throws Exception{
		return sqlSession.selectList(NS + "findProductByMaker", maker);
	}
	
	public List<MyProduct> findProducts() throws Exception{
		return sqlSession.selectList(NS + "findProducts");
	}
}

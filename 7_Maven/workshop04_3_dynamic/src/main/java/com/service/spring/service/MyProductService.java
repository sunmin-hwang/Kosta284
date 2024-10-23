package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;

//데이타 가공....SELECT문 / DELETE
@Service
public class MyProductService {

	@Autowired
	private MyProductDAO myProductDAO;

	public List<MyProduct> findProducts(String command, String word)  throws Exception{
		return myProductDAO.findProducts(command, word);
	}
}

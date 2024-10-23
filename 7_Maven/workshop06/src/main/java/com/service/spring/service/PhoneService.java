package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Service
public class PhoneService {
	@Autowired
	private PhoneDAO phoneDAO;
	
	@Transactional
	public int insert(Phone vo) {
		return phoneDAO.insert(vo);
	}
	
	public List<Phone> select() {
		return phoneDAO.select();
	}
	
	public Phone select(Phone vo) {
		return phoneDAO.select(vo);
	}
	
	public UserInfo select(UserInfo vo) {
		return phoneDAO.select(vo);
	}
	
	@Transactional
	public int delete(List<String> list) {
		return phoneDAO.delete(list);
	}
	
	public int update(Phone vo) {
		return phoneDAO.update(vo);
	}
}

package spring.service.dao.impl;

import spring.service.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void register(String name, String pass) {
		System.out.println(name + "님 등로로로로로로로록");
	}

	@Override
	public void delete(String id) {
		System.out.println(id + "님 삭제제제제제제제ㅔ제젲");
	}

}

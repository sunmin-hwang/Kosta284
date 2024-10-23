package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;


@Controller
public class MyProductController {
	
	@Autowired
	private MyProductDAO myProductDAO;
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("/insertProduct.do")
	public ModelAndView addProduct(MyProduct pvo) throws Exception {
		System.out.println("addProduct...");
		myProductDAO.addProduct(pvo);		
		
		//결과페이지 이름은 insert_result.jsp  포워딩 / vo 이름으로 Request에 바인딩
		return new ModelAndView("insert_result", "vo", pvo);
	}
	
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct(String command, String word) throws Exception {
		List<MyProduct> list = null;
		String viewPage = "find_result";
		if(command.equals("findProducts")) {
			System.out.println("findProducts...");
			list = myProductService.findProducts();
		}else if(command.equals("findProductByName")) {
			System.out.println("findProductByName...");
			list = myProductService.findProductByName(word);
		}else if(command.equals("findProductByMaker")) {
			System.out.println("findProductByMaker...");
			list = myProductService.findProductByMaker(word);
		}
		return new ModelAndView(viewPage,"list",list);
	}
}













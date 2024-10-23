package com.services.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.services.spring.service.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("/insertProduct.do")
	public ModelAndView addProduct(MyProduct myProduct) throws Exception {
		myProductService.addProduct(myProduct);
		List<MyProduct> list = myProductService.findProducts();
		
		return new ModelAndView("result", "list", list);
	}
	
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct(String option, String value) throws Exception {
		List<MyProduct> list = new ArrayList<MyProduct>();
		if(option.equals("name")) {
			list = myProductService.findProductByName(value);			
		}else if(option.equals("maker")){
			list = myProductService.findProductByMaker(value);
		}else {
			list = myProductService.findProducts();
		}
		
		return new ModelAndView("result", "list", list);
	}
}

package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Item> list = new ArrayList<Item>();
		String path = "index.jsp";
		try {
			list = ItemDao.getInstance().getAllItem();
			request.setAttribute("list", list);
			path = "itemList.jsp";				
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

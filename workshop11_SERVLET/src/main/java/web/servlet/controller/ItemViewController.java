package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int itemNumber =Integer.parseInt(request.getParameter("itemNumber"));
		Item item = null;
		String path = "itemList.jsp";
		try {
			ItemDao.getInstance().updateRecordCount(itemNumber);
			item = ItemDao.getInstance().getItem(itemNumber);
			request.setAttribute("item", item);
			path = "itemView.jsp";				
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}

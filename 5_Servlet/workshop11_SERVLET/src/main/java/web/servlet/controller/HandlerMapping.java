package web.servlet.controller;

public class HandlerMapping {
	
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() { }
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	public Controller createComponent(String command) {
		Controller controller = null;
		
		if(command.equals("list.do")) {
			controller = new ItemListController();
		} else if(command.equals("view.do")) {
			controller = new ItemViewController();
		}
		
		return controller;
	}
}

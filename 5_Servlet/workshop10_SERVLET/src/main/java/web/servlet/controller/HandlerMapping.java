package web.servlet.controller;

public class HandlerMapping {
	
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() { }
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	//Component를 생성하는 기능...
	public Controller createComponent(String command) {
		Controller controller = null;
		
		if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("book.do")) {
			controller = new BookController();
		} else if(command.equals("logout.do")) {
			controller = new LogoutController();
		} else if(command.equals("showBook.do")) {
			controller = new ShowBookController();
		}else if(command.equals("findByTitle.do")) {
			controller = new FindByTitleController();
		}
		
		return controller;
	}
}

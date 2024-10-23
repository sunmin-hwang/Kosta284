package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		
		return new ModelAndView("book/bookList","list",list);
	}
	
	@PostMapping("bookRegister.do")
	public ModelAndView register(String isbn1, String isbn2, String isbn3, Book book)throws Exception{
		String isbn = isbn1 + "-" + isbn2 + "-" + isbn3;
		book.setIsbn(isbn);
		System.out.println("register BookVO before:: "+book);//?
		
		String msg = "도서 등록에 실패하였습니다.";
		String path = "../../Error";
		try {
			if(bookService.searchByIsbn(isbn)==null) {
				bookService.insertBook(book);
				msg = "도서 등록에 성공하였습니다.";
				path = "redirect:result.jsp";
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path, "msg", msg);
	}
	
	@GetMapping("bookSearch.do")
    public ModelAndView search(String searchField, String searchText) throws Exception{ 
		
		List<Book> list = null;
		String path = "../../Error";
		
		try {
			switch (searchField) {
			case "LIST":
				list = bookService.getBooks();
				break;
			case "TITLE":
				list = bookService.searchByTitle(searchText);
				break;
			case "PUBLISHER":
				list = bookService.searchByPublisher(searchText);				
				break;
			case "PRICE":
				list = bookService.searchByPrice(Integer.parseInt(searchText));				
				break;
			}
			path="book/bookList";
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path, "list", list);
	}
	@GetMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
		Book book = null;
		String path = "../../Error";
		try {
			book = bookService.searchByIsbn(isbn);
			if(book != null) {
				path = "book/bookView";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path, "book", book);
	}	
	

}//






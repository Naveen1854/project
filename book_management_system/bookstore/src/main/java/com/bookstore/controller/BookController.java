package com.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;

@Controller
public class BookController {
	
//	@Autowired
//	private BookService service;
	
//	@Autowired
//	private MyBookListService myBookService;
	
	private final BookService bookService;
	private final MyBookListService myBookListService;
	
	public BookController(BookService bookService, MyBookListService myBookListService) {
		this.bookService = bookService;
		this.myBookListService = myBookListService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=bookService.getAllBook();
		ModelAndView m=new ModelAndView();
		m.setViewName("bookList");
		m.addObject("book",list);
		return m;
//		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		bookService.save(b);
		
		return "redirect:/available_books";
		
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookListService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=bookService.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}
	
}
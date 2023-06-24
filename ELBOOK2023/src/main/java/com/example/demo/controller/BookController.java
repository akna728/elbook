package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookList;
import com.example.demo.service.BookService;

import lombok.Data;

@RestController
@Data
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/bookList")
	public String bookInfo(Model model) {
		model.addAttribute("BookList", bookService.findBook());
		return "bookinfo";
	}
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<BookList> getAllBooks(){
		return bookService.findBook();
	}

}

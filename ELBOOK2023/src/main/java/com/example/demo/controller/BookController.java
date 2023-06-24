package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;

}

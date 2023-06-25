package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;

@SpringBootTest
public class BookTest {
	
	@Autowired
	private BookService bookService;
	
	//@Disabled
	@Test
	void findBookTest(){
		
		int count = 3;
		List<BookList> lists = bookService.findBook();
		System.out.println(lists.size());
		assertEquals(count, lists.size());
		
	}


}

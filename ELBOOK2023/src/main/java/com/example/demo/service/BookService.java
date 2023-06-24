package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookList;
import com.example.demo.mapper.BookMapper;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	public List<BookList> findBook(){
		return bookMapper.findBook();
	}
	
	public List<BookList> getBookList(int rental_key_id){
		return bookMapper.getBookList(rental_key_id);
	}

}

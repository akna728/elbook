package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.BookList;

@Mapper
@Repository
public interface BookMapper {
	
	List<BookList> findBook();
	
	List<BookList> getBookList(int rental_key_id);
	
	BookList targetBook(int book_id);
	
	void createBook(BookList bookList);
	
	void editBook(BookList bookList);
	
	void deleteBook(int book_id);
	
	int getMaxNumberBook();
	
	void rentalBook(int book_id);
	
	void returnBook(int book_id);

}

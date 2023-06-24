package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Rental;

@Mapper
public interface RentalMapper {
	
	void rentalBook(int rental_key_id, int book_id);
	
	void returnBook(int rental_key_id, int book_id);
	
	List<Rental> findRentalBook(int rental_key_id);
	
	List<Rental> findAllRentalBook();

}

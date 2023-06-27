package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Rental;
import com.example.demo.Mapper.RentalMapper;

public class RentalService {
	
	@Autowired
	RentalMapper rentalMapper;
	
	public void rentalBook(int rental_key_id, int book_id) {
		rentalMapper.rentalBook(rental_key_id, book_id);
	}
	
	public void returnBook(int rental_key_id, int book_id) {
		rentalMapper.returnBook(rental_key_id, book_id);
	}
	
	public List<Rental> findRentalBook(int rental_key_id, int book_id){
		return rentalMapper.findRentalBook(rental_key_id);
	}
	
	public List<Rental> findAllRentalBook(){
		return rentalMapper.findAllRentalBook();
	}

}

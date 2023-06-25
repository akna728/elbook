package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;

@Controller
public class BookController {
	
	@Autowired
    private BookService bookService;
	
	// コンポーネント間の結合度を低くし、柔軟性とテスト容易性を向上させる
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/bookinfo")
    public String bookInfo(Model model) {
        model.addAttribute("BookList", bookService.findBook());
        return "bookinfo";
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        int rental_key_id = 0;	//rental_key_idとは。
        List<BookList> bookList = bookService.getBookList(rental_key_id);
        model.addAttribute("bookList", bookList);
        return "booklist";
    }
    
    @GetMapping("/bookcreate")
    public String showBookCreateForm(Model model) {
        model.addAttribute("book", new BookList());
        return "bookcreate";
    }

    @PostMapping("/bookcreate")
    public String createBook(@ModelAttribute("book") BookList book) {
        bookService.createBook(book);
        return "redirect:/bookcreate";
    }

    @GetMapping("/bookedit/{bookId}")
    public String showBookEditForm(@PathVariable("bookId") int bookId, Model model) {
        BookList book = bookService.targetBook(bookId);
        model.addAttribute("book", book);
        return "bookedit";
    }

    @PostMapping("/bookedit/{bookId}")
    public String editBook(@PathVariable("bookId") int bookId, @ModelAttribute("book") BookList bookList) {
        bookService.editBook(bookList);
        return "redirect:/bookedit";
    }

    @GetMapping("/bookdelete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/bookdelete";
    }
}

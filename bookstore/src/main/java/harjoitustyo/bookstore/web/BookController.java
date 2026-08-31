package harjoitustyo.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import harjoitustyo.bookstore.domain.Book;
import harjoitustyo.bookstore.domain.BookRepository;

@Controller
public class BookController {

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("/booklist")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
    }

     @PostMapping("/saveBook")
    public String saveBookToList(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}


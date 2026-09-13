package harjoitustyo.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.bookstore.domain.Book;
import harjoitustyo.bookstore.domain.BookRepository;

import harjoitustyo.bookstore.domain.Category;
import harjoitustyo.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Lisätään demodataa h2-kantaan

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category fantasia = new Category("Fantasia");
			Category jannitys = new Category("Jännitys");
			Category romantiikka = new Category("Romantiikka");

			categoryRepository.save(fantasia);
			categoryRepository.save(jannitys);
			categoryRepository.save(romantiikka);

			Book book1 = new Book("Velhojen koulu", "Kimmo Kirjailija", 2002, "98765432", 19.90, fantasia);
			bookRepository.save(book1);

			Book book2 = new Book("Satumainen naapuri", "Keijo Kirjailija", 2019, "123455666", 22.50, romantiikka);
			bookRepository.save(book2);

			for (Book book : bookRepository.findAll()) {
				System.out.println(book);
			}
		};
	}
}

package harjoitustyo.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.bookstore.domain.Book;
import harjoitustyo.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Lisätään demodataa h2-kantaan

	@Bean
public CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
		Book book1 = new Book("Kirjan nimi", "Kimmo Kirjailija", 2002, "98765432", 19.90);
		bookRepository.save(book1);
		Book book2 = new Book("Satumaa", "Keijo Kirjailija", 2019, "123455666", 22.50);
		bookRepository.save(book2);
	};
}

}

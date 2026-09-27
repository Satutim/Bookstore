package harjoitustyo.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.bookstore.domain.Book;
import harjoitustyo.bookstore.domain.BookRepository;

import harjoitustyo.bookstore.domain.Category;
import harjoitustyo.bookstore.domain.CategoryRepository;

import harjoitustyo.bookstore.domain.User;
import harjoitustyo.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
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

			User user1 = new User(
					"user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@bookstore.com",
					"USER");

			userRepository.save(user1);

			User user2 = new User(
					"admin",
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@bookstore.com",
					"ADMIN");

			userRepository.save(user2);

			for (Book book : bookRepository.findAll()) {
				System.out.println(book);
			}
		};
	}
}

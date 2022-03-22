package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			Category category1 = new Category("Drama");
			crepository.save(category1);
			Category category2 = new Category("Action");
			crepository.save(category2);
			Category category3 = new Category("Comic");
			crepository.save(category3);
			Category category4 = new Category("Fantasy");
			crepository.save(category4);
			
			brepository.save(new Book("Anna-Leena Härkönen", "Häräntappoase", 3678901, 1984, category1));
			brepository.save(new Book("Tove Jansson", "Muumipeikko",  2578901, 1940, category2));	
			
			
			User user1 = new User("user", "$2a$10$0yJX1Q2lCUhE/M88XhuD4OSeCa56h9kFDAJwB3Fa9G7URUKeBxo4O", "USER", "user@mail.com");
			User user2 = new User("admin", "$2a$10$PsDS6BrGjXGh.diU9aQXeeX6pk5GbPpXT0ogZcTvEcdPGg.ByYVou", "ADMIN", "admin@mail.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
				
			
					
}
};
		};	
	}
		
	

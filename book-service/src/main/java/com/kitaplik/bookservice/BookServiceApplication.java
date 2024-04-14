package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepository repository;

    public BookServiceApplication(BookRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Yeraltından Notlar", 1864, "Fyodor Dostoyevski", "Kültür Yayınları", "123456");
        Book book2 = new Book("Serenad", 2011, "Zülfü Livaneli", "Doğan Kitap.", "987654");
        Book book3 = new Book("Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayınları", "456789");

        List<Book> books = repository.saveAll(Arrays.asList(book1, book2, book3));
        System.out.println(books);
    }
}

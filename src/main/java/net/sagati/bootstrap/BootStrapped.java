package net.sagati.bootstrap;

import net.sagati.model.Author;
import net.sagati.model.Book;
import net.sagati.model.Publisher;
import net.sagati.repositories.AuthorRepository;
import net.sagati.repositories.BookRepository;
import net.sagati.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BootStrapped implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapped(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher myPublisher = new Publisher("ABC Publisher","Address1","Address2","Karpur","Karnataka","562016");
        this.publisherRepository.save(myPublisher);
        Author manju = new Author("Manjunatha", "Muniyappa");
        Book manjuBook = new Book("Learn Spring", "1234");
        manju.getBooks().add(manjuBook);
        manjuBook.getAuthors().add(manju);
        myPublisher.getBooks().add(manjuBook);
        manjuBook.setPublisher(myPublisher);
        this.authorRepository.save(manju);
        this.bookRepository.save(manjuBook);
        this.publisherRepository.save(myPublisher);

        Author vaishnav = new Author("Vaishnav", "Manjunatha");
        Book vaishnavBook = new Book("Learn Math", "5678");
        vaishnav.getBooks().add(vaishnavBook);
        vaishnavBook.getAuthors().add(vaishnav);
        vaishnavBook.setPublisher(myPublisher);
        myPublisher.getBooks().add(vaishnavBook);

        this.authorRepository.save(vaishnav);
        this.bookRepository.save(vaishnavBook);
        this.publisherRepository.save(myPublisher);

        Author praveena = new Author("Praveena", "Manjunatha");
        Book praveenaBook = new Book("Learn BI", "89012");
        praveenaBook.getAuthors().add(praveena);
        myPublisher.getBooks().add(praveenaBook);
        praveenaBook.setPublisher(myPublisher);
        this.authorRepository.save(praveena);
        this.bookRepository.save(praveenaBook);
        this.publisherRepository.save(myPublisher);

        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + this.publisherRepository.count());
        System.out.println("Number of books for publisher "+myPublisher.getBooks().size());
    }
}

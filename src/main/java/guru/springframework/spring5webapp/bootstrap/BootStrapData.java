package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Book1
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "2313456123");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        // Book2
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "6123422432");
        eric.getBooks().add(book2);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);

        // Verification
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}

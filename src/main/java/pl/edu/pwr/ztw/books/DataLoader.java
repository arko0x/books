package pl.edu.pwr.ztw.books;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.edu.pwr.ztw.books.entity.Author;
import pl.edu.pwr.ztw.books.entity.Book;
import pl.edu.pwr.ztw.books.repository.AuthorsRepository;
import pl.edu.pwr.ztw.books.repository.BooksRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private BooksRepository booksRepository;
    private AuthorsRepository authorsRepository;

    public DataLoader(BooksRepository booksRepository, AuthorsRepository authorsRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
    }

    public void run(ApplicationArguments args) {
        Author firstAuthor = new Author( "Henryk", "Sienkiewicz", Gender.MALE);
        Author secondAuthor = new Author("Stanislaw", "Wyspianski", Gender.MALE);
        Author thirdAuthor = new Author("Adam", "Mickiewcz", Gender.MALE);
        authorsRepository.save(firstAuthor);
        authorsRepository.save(secondAuthor);
        authorsRepository.save(thirdAuthor);

        booksRepository.save(new Book("Potop", firstAuthor, 936));
        booksRepository.save(new Book("Wesele", secondAuthor, 150));
        booksRepository.save(new Book("Dziady", thirdAuthor, 292));
    }
}

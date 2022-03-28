package pl.edu.pwr.ztw.books.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.ztw.books.entity.Book;

import java.util.Collection;

public interface BooksRepository extends CrudRepository<Book, Integer> {
    Collection<Book> findAll();
}

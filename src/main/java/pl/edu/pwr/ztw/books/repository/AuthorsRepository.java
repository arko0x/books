package pl.edu.pwr.ztw.books.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.ztw.books.entity.Author;

import java.util.List;

public interface AuthorsRepository extends CrudRepository<Author, Integer> {
    @Override
    List<Author> findAll();
}

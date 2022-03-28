package pl.edu.pwr.ztw.books;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.entity.Author;
import pl.edu.pwr.ztw.books.entity.Book;
import pl.edu.pwr.ztw.books.repository.AuthorsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthorsService implements IAuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public Author getAuthor(int id) {
        return authorsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        authorsRepository.save(author);
        return author;
    }

    @Override
    public Author updateAuthor(Author author) {
        authorsRepository.save(author);
        return author;
    }

    @Override
    public boolean deleteAuthor(int id) {
        authorsRepository.deleteById(id);
        return true;
    }
}

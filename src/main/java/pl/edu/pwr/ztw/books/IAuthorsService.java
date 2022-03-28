package pl.edu.pwr.ztw.books;

import pl.edu.pwr.ztw.books.entity.Author;

import java.util.List;

public interface IAuthorsService {
    Author getAuthor(int id);
    List<Author> getAuthors();
    Author createAuthor(Author author);
    Author updateAuthor(Author author);
    boolean deleteAuthor(int id);
}

package pl.edu.pwr.ztw.books;

import pl.edu.pwr.ztw.books.entity.Book;

import java.util.Collection;

public interface IBooksService {
    Book getBook(int id);
    Collection<Book> getBooks();
    Book createBook(BookDto book);
    Book updateBook(int id, BookDto book);
    boolean deleteBook(int id);
}

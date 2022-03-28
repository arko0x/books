package pl.edu.pwr.ztw.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.entity.Author;
import pl.edu.pwr.ztw.books.entity.Book;
import pl.edu.pwr.ztw.books.repository.BooksRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class BooksService implements IBooksService {
    private final BooksRepository booksRepository;
    private final AuthorsService authorsService;

//    static {
//        booksRepo.add(new Book(1, "Potop", authorsService.getAuthor(1), 936));
//        booksRepo.add(new Book(2, "Wesele", authorsService.getAuthor(2), 150));
//        booksRepo.add(new Book(3, "Dziady", authorsService.getAuthor(3), 292));
//    }

    @Override
    public Book getBook(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Book> getBooks() {
        return booksRepository.findAll();
    }
    
    @Override
    public Book createBook(BookDto bookDto){
        if (bookDto.pages <= 0){
            throw new IllegalArgumentException();
        }
        Author author = authorsService.getAuthor(bookDto.getAuthorId());
        if (author != null) {
            Book book = new Book(bookDto.getTitle(), author, bookDto.pages);
            booksRepository.save(book);
            return book;
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Book updateBook(int id, BookDto bookDto) {
        if (bookDto.pages < 0){
            throw new IllegalArgumentException();
        }
        Author author = authorsService.getAuthor(bookDto.getAuthorId());
        if (author != null) {
            Book book = booksRepository.findById(id).orElse(null);
            if (book != null) {
                book.setAuthor(author);
                book.setPages(bookDto.getPages());
                book.setTitle(bookDto.getTitle());
                booksRepository.save(book);
                return book;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public boolean deleteBook(int id) {
        booksRepository.deleteById(id);
        return true;
    }
}


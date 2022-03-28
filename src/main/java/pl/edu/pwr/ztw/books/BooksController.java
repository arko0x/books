package pl.edu.pwr.ztw.books;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.entity.Book;

import java.net.URI;
import java.util.Collection;

@RestController
@AllArgsConstructor
public class BooksController {
    private IBooksService booksService;

    @GetMapping("/get/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        return ResponseEntity.ok(booksService.getBook(id));
    }

    @GetMapping("/get/books")
    public ResponseEntity<Collection<Book>> getBooks() {
        return ResponseEntity.ok(booksService.getBooks());
    }

    @PostMapping("/post/book")
    @ApiResponses(@ApiResponse(responseCode = "201"))
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book book = booksService.createBook(bookDto);
        return ResponseEntity.created(URI.create("/books" + book.getId())).body(book);
    }

    @PutMapping("/put/book/{id}")
    @ApiResponses(@ApiResponse(responseCode = "202"))
    public ResponseEntity<Book> updateBook(@RequestBody BookDto bookDto, @PathVariable int id) {
        Book book = booksService.updateBook(id, bookDto);
        return ResponseEntity.accepted().body(book);
    }

    @DeleteMapping("/delete/book/{id}")
    @ApiResponses(@ApiResponse(responseCode = "204"))
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

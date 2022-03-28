package pl.edu.pwr.ztw.books;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.entity.Author;

import java.net.URI;
import java.util.Collection;


@RestController
@AllArgsConstructor
public class AuthorsController {
    private IAuthorsService authorsService;

    @GetMapping("/get/author/{id}")
    public ResponseEntity<Author> getBook(@PathVariable("id") int id) {
        return ResponseEntity.ok(authorsService.getAuthor(id));
    }

    @GetMapping("/get/authors")
    public ResponseEntity<Collection<Author>> getBooks() {
        return ResponseEntity.ok(authorsService.getAuthors());
    }

    @PostMapping("/post/author")
    @ApiResponses(@ApiResponse(responseCode = "201"))
    public ResponseEntity<Author> addBook(@RequestBody Author author) {
        authorsService.createAuthor(author);
        return ResponseEntity.created(URI.create("/books" + author.getId())).body(author);
    }

    @PutMapping("/put/author")
    @ApiResponses(@ApiResponse(responseCode = "202"))
    public ResponseEntity<Author> updateBook(@RequestBody Author author) {
        authorsService.updateAuthor(author);
        return ResponseEntity.accepted().body(author);
    }

    @DeleteMapping("/delete/author/{id}")
    @ApiResponses(@ApiResponse(responseCode = "204"))
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        authorsService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}

package com.genpact.librarymanagement.web.rest;

import com.genpact.librarymanagement.dto.BookDTO;
import com.genpact.librarymanagement.dto.BookRequestDTO;
import com.genpact.librarymanagement.dto.BookResponseDTO;
import com.genpact.librarymanagement.model.Library;
import com.genpact.librarymanagement.repository.BookRepository;
import com.genpact.librarymanagement.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author 703237279 on Jul, 2020
 */

@RestController
@Api(tags = { "BookController" })
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/books/add")
    @ApiOperation(value = "Post Method to add books in Library")
    public ResponseEntity<BookDTO> addBooks(
            @RequestBody BookDTO bookDTO) {
        bookService.addBooks(bookDTO);

        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.ACCEPTED);

    }

    @GetMapping("/books/{bookId}")
    @ApiOperation(value = "Get method to retrieve  book based on Id")
    public ResponseEntity<BookResponseDTO> getBooksOnId(@PathVariable(value = "bookId") Long bookId) {
        BookResponseDTO bookResponseDTO = bookService.getBook(bookId);
        return new ResponseEntity<BookResponseDTO>(bookResponseDTO, HttpStatus.OK);
    }



    @GetMapping("/books/library/{libraryId}")
    @ApiOperation(value = "Get method to retrieve list of books")
    public ResponseEntity<List<BookResponseDTO>> getBooksInLibrary(@PathVariable(value = "libraryId") Long libraryId) {
        List<BookResponseDTO> bookDTOList = bookService.getAllBooksInLibrary(libraryId);
        return new ResponseEntity<List<BookResponseDTO>>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping("/books")
    @ApiOperation(value = "Get Method to retrieve list of all Books")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> bookResponseDTO = bookService.getAllBooks();

        return new ResponseEntity<List<BookResponseDTO>>(bookResponseDTO, HttpStatus.OK);

    }

    @PutMapping("/books/{bookId}/libraries/{libraryId}")
    @ApiOperation(value = "Put Method to update books")
    public ResponseEntity<Boolean> editBook(@PathVariable Long bookId,@PathVariable Long libraryId,@RequestBody BookRequestDTO bookRequest) {
        Boolean updated=bookService.updateBook(bookId,libraryId,bookRequest);
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);

    }



    @PutMapping("/books/{bookId}")
    @ApiOperation(value = "Put Method to update books based on Id")
    public ResponseEntity<Boolean> editBookBasedOnId(@PathVariable Long bookId,@RequestBody BookRequestDTO bookRequest) {
        Boolean updated=bookService.updateBook(bookId,bookRequest);
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);

    }


    @DeleteMapping("/books/{bookId}/libraries/{libraryId}")
    @ApiOperation(value = "Delete Method to remove book by checking libraryId")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long bookId,@PathVariable Long libraryId) {
        Boolean deleted=bookService.deleteBook(bookId,libraryId);
        return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);

    }

    @DeleteMapping("/books/{bookId}")
    @ApiOperation(value = "Delete Method to remove book based on Id")
    public ResponseEntity<Boolean> deleteBookBasedOnId(@PathVariable Long bookId) {
        Boolean deleted=bookService.deleteBook(bookId);
        return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);

    }


}

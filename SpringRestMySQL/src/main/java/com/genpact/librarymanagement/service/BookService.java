package com.genpact.librarymanagement.service;

import com.genpact.librarymanagement.dto.BookDTO;
import com.genpact.librarymanagement.dto.BookRequestDTO;
import com.genpact.librarymanagement.dto.BookResponseDTO;

import java.util.List;

/**
 * @author 703237279 on Jul, 2020
 */
public interface BookService {

    public boolean addBooks(BookDTO bookDTO);
    public BookResponseDTO getBook(Long bookId);
    public List<BookResponseDTO> getAllBooksInLibrary(Long libraryId);
    public List<BookResponseDTO> getAllBooks();
    public Boolean updateBook(Long bookId, Long libraryId, BookRequestDTO bookRequestDTO);
    public Boolean updateBook(Long bookId,BookRequestDTO bookRequestDTO);
    public Boolean deleteBook(Long bookId, Long libraryId);
    public Boolean deleteBook(Long bookId);
}

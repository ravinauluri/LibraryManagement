package com.genpact.librarymanagement.serviceImpl;

import com.genpact.librarymanagement.dto.BookDTO;
import com.genpact.librarymanagement.dto.BookRequestDTO;
import com.genpact.librarymanagement.dto.BookResponseDTO;
import com.genpact.librarymanagement.exception.BadRequestAlertException;
import com.genpact.librarymanagement.model.Book;
import com.genpact.librarymanagement.model.Library;
import com.genpact.librarymanagement.repository.BookRepository;
import com.genpact.librarymanagement.repository.LibraryRepository;
import com.genpact.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 703237279 on Jul, 2020
 */
@Service
public class BookServiceImpl implements BookService {


    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    @Transactional
    public boolean addBooks(BookDTO bookDTO) {
        if (validateCreateBookRequest(bookDTO)) {
            throw new BadRequestAlertException("Invalid Input Details");
        }

        Optional<Library> libraryOptional = libraryRepository.findById(bookDTO.getLibraryId());

        if (libraryOptional.isPresent()) {
            Library library = libraryOptional.get();
            Book book = new Book();
            book.setPrice(bookDTO.getPrice());
            book.setAuthor(bookDTO.getAuthor());
            book.setPublisher(bookDTO.getPublisher());
            book.setTitle(bookDTO.getTitle());
//            book.setLibrary(library);
            bookRepository.save(book);
        } else {
            throw new BadRequestAlertException("LibraryId " + bookDTO.getLibraryId() + " not found");
        }

        return true;
    }


    @Override
    public BookResponseDTO getBook(Long bookId) {

        Optional<Book> optionalLibrary = bookRepository.findById(bookId);
        if (!optionalLibrary.isPresent()) {
            throw new BadRequestAlertException("BookId " + bookId + " not found");
        }
        BookResponseDTO bookResponseDTO= new BookResponseDTO();
        Book book=optionalLibrary.get();
        bookResponseDTO.setBookId(book.getId());
//        bookResponseDTO.setLibraryId(book.getLibrary().getId());
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setPublisher(book.getPublisher());
        bookResponseDTO.setPrice(book.getPrice());
        bookResponseDTO.setAuthor(book.getAuthor());
        return bookResponseDTO;

    }

    @Override
    public List<BookResponseDTO> getAllBooksInLibrary(Long libraryId) {

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);

        if (!optionalLibrary.isPresent()) {
            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }

        List<Book> books = (List<Book>) bookRepository.findAll();
        BookResponseDTO bookDTO = null;
        List<BookResponseDTO> bookDTOList = new ArrayList<>();

        List<Book> bookList = bookRepository.findByLibraryId(libraryId);

        if (bookList.size() > 0) {
            for (Book book : bookList) {
                bookDTO = new BookResponseDTO();
                bookDTO.setBookId(book.getId());
                bookDTO.setTitle(book.getTitle());
                bookDTO.setAuthor(book.getAuthor());
                bookDTO.setPrice(book.getPrice());
                bookDTO.setPublisher(book.getPublisher());
//                bookDTO.setLibraryId(book.getLibrary().getId());
                bookDTOList.add(bookDTO);
            }
        } else {
            throw new BadRequestAlertException("List is empty");
        }

        return bookDTOList;
    }


    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        BookResponseDTO dto = null;
        if (books.size() > 0) {
            for (Book book : books) {
                dto = new BookResponseDTO();
                dto.setBookId(book.getId());
                dto.setAuthor(book.getAuthor());
                dto.setPrice(book.getPrice());
                dto.setPublisher(book.getPublisher());
                dto.setTitle(book.getTitle());
//                dto.setLibraryId(book.getLibrary().getId());
                bookResponseDTOList.add(dto);
            }
        } else {
            throw new BadRequestAlertException("List is empty");
        }

        return bookResponseDTOList;
    }


    @Override
    public Boolean updateBook(Long bookId, Long libraryId, BookRequestDTO bookRequestDTO) {

        if (!libraryRepository.existsById(libraryId)) {
            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookRequestDTO.getTitle());
            book.setAuthor(bookRequestDTO.getAuthor());
            book.setPublisher(bookRequestDTO.getPublisher());
            book.setPrice(bookRequestDTO.getPrice());
            bookRepository.save(book);
        } else {

            throw new BadRequestAlertException("BookId " + bookId + " not found");
        }
        return true;
    }

    @Override
    public Boolean updateBook(Long bookId,BookRequestDTO bookRequestDTO) {

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookRequestDTO.getTitle());
            book.setAuthor(bookRequestDTO.getAuthor());
            book.setPublisher(bookRequestDTO.getPublisher());
            book.setPrice(bookRequestDTO.getPrice());
            bookRepository.save(book);
        } else {

            throw new BadRequestAlertException("BookId " + bookId + " not found");
        }
        return true;
    }


    @Override
    public Boolean deleteBook(Long bookId, Long libraryId) {

        /*Can Check using bookId and libraryId both Optional*/
        //Optional<Book> bookOptional = bookRepository.findByBookId(libraryId,bookId);

        if (!libraryRepository.existsById(libraryId)) {
            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(bookOptional.isPresent()){
            bookRepository.deleteById(bookId);
        }
        else
        {

            throw new BadRequestAlertException("BookId " + bookId + " not found");
        }

        return true;
    }

    @Override
    public Boolean deleteBook(Long bookId) {

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(bookOptional.isPresent()) {
            bookRepository.deleteById(bookId);
        }
        else
        {
            throw new BadRequestAlertException("BookId " + bookId + " not found");
        }
        return true;
    }




    private boolean validateCreateBookRequest(BookDTO dto)
            throws BadRequestAlertException {
        if (StringUtils
                .isEmpty(dto.getTitle()) || dto.getAuthor() == null || dto.getAuthor() == null
                || dto.getPrice() == null || dto.getPublisher() == null
        ) {
            return true;
        }

        return false;

    }


}

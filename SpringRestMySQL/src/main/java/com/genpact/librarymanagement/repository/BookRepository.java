package com.genpact.librarymanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.librarymanagement.model.Book;

/**
 * @author 703237279 on Jul, 2020
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
    List<Book> findByLibraryId(Long libraryId);
    Optional<Book> findByIdAndLibraryId(Long id, Long libraryId);

}

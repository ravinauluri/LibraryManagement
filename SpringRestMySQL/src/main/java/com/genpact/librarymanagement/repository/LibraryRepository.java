package com.genpact.librarymanagement.repository;

import com.genpact.librarymanagement.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 703237279 on Jul, 2020
 */
public interface LibraryRepository extends JpaRepository<Library,Long> {

    Library findByName(String name);

}

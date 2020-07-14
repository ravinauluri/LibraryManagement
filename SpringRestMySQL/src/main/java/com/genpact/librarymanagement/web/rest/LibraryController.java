package com.genpact.librarymanagement.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.librarymanagement.dto.LibraryDTO;
import com.genpact.librarymanagement.dto.LibraryRequestDTO;
import com.genpact.librarymanagement.dto.LibraryResponseDTO;
import com.genpact.librarymanagement.service.BookService;
import com.genpact.librarymanagement.service.LibraryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author 703237279 on Jul, 2020
 */
@RestController
@Api(tags = { "LibraryController" })
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    BookService bookService;


    @PostMapping("/libraries")
    @ApiOperation(value = "Post Method to create Library")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO libraryDto) {
            libraryService.saveLibrary(libraryDto);
        return new ResponseEntity<LibraryDTO>(libraryDto, HttpStatus.ACCEPTED);

    }


    @GetMapping("/libraries")
    @ApiOperation(value = "Get Method to retrieve list of  Libraries")
    public ResponseEntity<List<LibraryResponseDTO>> getAllLibraries() {
        List<LibraryResponseDTO> libraryResponseDTO=libraryService.getAllLibraries();

        return new ResponseEntity<List<LibraryResponseDTO>>(libraryResponseDTO, HttpStatus.OK);

    }


    @GetMapping("/libraries/{libraryId}")
    @ApiOperation(value = "Get Method to retrieve a library")
    public ResponseEntity<LibraryResponseDTO> getLibrary(@PathVariable Long libraryId) {
        LibraryResponseDTO libraryResponseDTO=libraryService.getLibrary(libraryId);
        return new ResponseEntity<LibraryResponseDTO>(libraryResponseDTO, HttpStatus.OK);

    }


    @PutMapping("/libraries/{libraryId}")
    @ApiOperation(value = "Put Method to update library")
    public ResponseEntity<Boolean> editLibrary(@PathVariable Long libraryId, @RequestBody LibraryRequestDTO libraryRequest) {
       Boolean updated=libraryService.updateLibrary(libraryId,libraryRequest);
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);

    }


    @DeleteMapping("/libraries/{libraryId}")
    @ApiOperation(value = "Delete Method to remove library")
    public ResponseEntity<Boolean> deleteLibrary(@PathVariable Long libraryId) {
        Boolean deleted=libraryService.deleteLibrary(libraryId);
        return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);

    }



}

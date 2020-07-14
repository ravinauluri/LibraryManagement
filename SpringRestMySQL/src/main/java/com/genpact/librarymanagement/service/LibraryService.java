package com.genpact.librarymanagement.service;

import com.genpact.librarymanagement.dto.LibraryDTO;
import com.genpact.librarymanagement.dto.LibraryRequestDTO;
import com.genpact.librarymanagement.dto.LibraryResponseDTO;

import java.util.List;

/**
 * @author 703237279 on Jul, 2020
 */
public interface LibraryService {

    public Boolean saveLibrary(LibraryDTO dto);
    public List<LibraryResponseDTO> getAllLibraries();
    public LibraryResponseDTO getLibrary(Long libraryId);
    public Boolean updateLibrary(Long libraryId, LibraryRequestDTO libraryDTO);
    public Boolean deleteLibrary(Long libraryId);
}

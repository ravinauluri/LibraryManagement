package com.genpact.librarymanagement.serviceImpl;

import com.genpact.librarymanagement.dto.LibraryDTO;
import com.genpact.librarymanagement.dto.LibraryRequestDTO;
import com.genpact.librarymanagement.dto.LibraryResponseDTO;
import com.genpact.librarymanagement.exception.BadRequestAlertException;
import com.genpact.librarymanagement.model.Library;
import com.genpact.librarymanagement.repository.LibraryRepository;
import com.genpact.librarymanagement.service.LibraryService;
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
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    @Transactional
    public Boolean saveLibrary(LibraryDTO dto) {

        if(validateCreateLibraryRequest(dto)) {
            throw new BadRequestAlertException("Invalid Input Details");
        }
        Library library=new Library();
        library.setName(dto.getName());
        library.setAddress(dto.getAddress());
        library.setContactNumber(dto.getContactNumber());
        libraryRepository.save(library);
        return  true;
    }


    @Override
    public List<LibraryResponseDTO> getAllLibraries() {

        List<LibraryResponseDTO> libraryResponseDTOList = new ArrayList<>();

        List<Library> library=libraryRepository.findAll();

        LibraryResponseDTO dto = null;

        if(library.size()>0) {
            for (Library lib : library) {

                dto = new LibraryResponseDTO();
                dto.setLibraryId(lib.getId());
                dto.setName(lib.getName());
                dto.setAddress(lib.getAddress());
                dto.setContactNumber(lib.getContactNumber());
                libraryResponseDTOList.add(dto);
            }

        }
        else
        {
            throw new BadRequestAlertException("List is empty");
        }

        return libraryResponseDTOList;
    }


    @Override
    public Boolean updateLibrary(Long libraryId, LibraryRequestDTO libraryDTO) {

        Optional<Library> libraryOptional = libraryRepository.findById(libraryId);

        if(libraryOptional.isPresent()){
            Library library = libraryOptional.get();
            library.setName(libraryDTO.getName());
            library.setAddress(libraryDTO.getAddress());
            library.setContactNumber(libraryDTO.getContactNumber());
            libraryRepository.save(library);
        }
        else
        {

            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }



        return true;
    }


    @Override
    public Boolean deleteLibrary(Long libraryId) {


        Optional<Library> libraryOptional = libraryRepository.findById(libraryId);

        if(libraryOptional.isPresent()){
            libraryRepository.deleteById(libraryId);
        }
        else
        {

            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }

        return  true;
    }


    @Override
    public LibraryResponseDTO getLibrary(Long libraryId) {

        Optional<Library> libraryOptional=libraryRepository.findById(libraryId);
        LibraryResponseDTO dto = new LibraryResponseDTO();
        if (libraryOptional.isPresent()) {
            Library library = libraryOptional.get();
            dto.setLibraryId(library.getId());
            dto.setName(library.getName());
            dto.setAddress(library.getAddress());
            dto.setContactNumber(library.getContactNumber());
            }

        else
        {
            throw new BadRequestAlertException("LibraryId " + libraryId + " not found");
        }

        return dto;
    }

    private boolean validateCreateLibraryRequest(LibraryDTO dto)
            throws BadRequestAlertException {
        if(StringUtils
                .isEmpty(dto.getName()) || dto.getAddress() == null || dto.getContactNumber() == null) {
            return true;
        }

        return false;

    }
}

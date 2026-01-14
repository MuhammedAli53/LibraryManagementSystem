package com.library_management_system.Service;

import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;

public interface GenreService {
    GenreDTO createGenre(GenreDTO genre);

private String nameUpper(String name){
    return name.toUpperCase();
}
    private String nameLower(String name){
        return name.toLowerCase();}

}



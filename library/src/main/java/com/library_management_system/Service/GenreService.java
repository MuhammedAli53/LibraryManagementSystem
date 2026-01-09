package com.library_management_system.Service;

import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;

public interface GenreService {
    GenreDTO createGenre(GenreDTO genre);
}

package com.library_management_system.Service.impl;

import com.library_management_system.Service.GenreService;
import com.library_management_system.modal.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}

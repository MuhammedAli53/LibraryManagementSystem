package com.library_management_system.Service.impl;

import com.library_management_system.Repository.GenreRepository;
import com.library_management_system.Service.GenreService;
import com.library_management_system.modal.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}

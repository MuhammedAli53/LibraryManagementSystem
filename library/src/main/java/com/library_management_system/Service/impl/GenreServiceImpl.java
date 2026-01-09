package com.library_management_system.Service.impl;

import com.library_management_system.Repository.GenreRepository;
import com.library_management_system.Service.GenreService;
import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
      // return genreRepository.save(genreDTO);

        Genre genre = Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();
        if (genreDTO.getParentGenreId()!=null){
            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId()).get();
            genre.setParentGenre(parentGenre);
        }
        Genre savedGenre = genreRepository.save(genre);

        GenreDTO dto = GenreDTO.builder()
                .id(savedGenre.getId())
                .code(savedGenre.getCode())
                .name(savedGenre.getName())
                .description(savedGenre.getDescription())
                .displayOrder(savedGenre.getDisplayOrder())
                .active(savedGenre.getActive())
                .createdAt(savedGenre.getCreatedAt())
                .updatedAt(savedGenre.getUpdatedAt())
                .build();
        if (savedGenre.getParentGenre()!= null){
            dto.setParentGenreId(savedGenre.getParentGenre().getId());
            dto.setParentGenreName(savedGenre.getParentGenre().getName());
        }

        //dto.setSubGenre(savedGenre.getSubGenres().stream().filter(subGenre-> subGenre.getActive()).map(subGenre ->));
           // dto.setBookCount((long) (savedGenre.getB));
        return dto;
    }
}

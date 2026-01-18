package com.library_management_system.Service.impl;

import com.library_management_system.Repository.GenreRepository;
import com.library_management_system.Service.GenreService;
import com.library_management_system.mapper.GenreMapper;
import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final GenreMapper genreMapper;

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

        return genreMapper.toDTO(savedGenre);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(genreMapper::toDTO)
                .collect(Collectors.toList());
    }
}

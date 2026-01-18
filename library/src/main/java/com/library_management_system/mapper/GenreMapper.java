package com.library_management_system.mapper;

import com.library_management_system.Repository.GenreRepository;
import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenreMapper {

    private final GenreRepository genreRepository;

    public GenreDTO toDTO(Genre savedGenre){
        if (savedGenre == null){
            return null;
        }

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

        if (savedGenre.getSubGenres()!=null && !savedGenre.getSubGenres().isEmpty()){
            dto.setSubGenre(savedGenre.getSubGenres().stream()
                    .filter(subGenre-> subGenre.getActive())
                    .map(subGenre ->toDTO((savedGenre))).collect(Collectors.toList()));
        }


         //dto.setBookCount((long) (savedGenre.getB));
        return dto;
    }

    public Genre toEntity(GenreDTO genreDTO){
        if (genreDTO==null){
            return null;
        }
        Genre genre = Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();
        if (genreDTO.getParentGenreId()!=null){
            genreRepository.findById(genreDTO.getParentGenreId()).ifPresent(genre::setParentGenre);
        }
        return genre;
    }

}

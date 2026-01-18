package com.library_management_system.controller;


import com.library_management_system.Service.GenreService;
import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {


    private final GenreService genreService;

    // add genre
    @PostMapping("/create")
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genre){
        GenreDTO createdGenre = genreService.createGenre(genre);
        return ResponseEntity.ok(createdGenre);

    }

    //getGenres
    @GetMapping("/getAllGenres")
    public ResponseEntity<?> getAllGenres(){
        List<GenreDTO> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);

    }
}

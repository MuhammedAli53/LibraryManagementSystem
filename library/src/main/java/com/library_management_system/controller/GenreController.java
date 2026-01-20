package com.library_management_system.controller;


import com.library_management_system.Service.GenreService;
import com.library_management_system.exception.GenreException;
import com.library_management_system.modal.Genre;
import com.library_management_system.payload.dto.GenreDTO;
import com.library_management_system.payload.response.ApiResponse;
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
    //getGenreById
    @GetMapping("/{genreId}")
    public ResponseEntity<?> getGenreById(@RequestParam("genreId") Long genreId) throws GenreException {
        GenreDTO genre = genreService.getGenreById(genreId);
        return ResponseEntity.ok(genre);

    }
    //updateGenre
    @PutMapping("/{genreId}")
    public ResponseEntity<?> updateGenre(@RequestParam("genreId") Long genreId, @RequestBody GenreDTO genreDTO) throws GenreException {
        GenreDTO genres = genreService.updateGenre(genreId, genreDTO);
        return ResponseEntity.ok(genres);

    }

    //deleteGenre
    @DeleteMapping("/{genreId}")
    public ResponseEntity<?> deleteGenre(@RequestParam("genreId") Long genreId) throws GenreException {
        genreService.deleteGenre(genreId);
        ApiResponse response = new ApiResponse("Genre deleted - soft delete", true);
        return ResponseEntity.ok(response);

    }

    //hardDeleteGenre
    @DeleteMapping("/{genreId}/hard")
    public ResponseEntity<?> hardDeleteGenre(@RequestParam("genreId") Long genreId) throws GenreException {
        genreService.hardDeleteGenre(genreId);
        ApiResponse response = new ApiResponse("Genre deleted - hard delete", true);
        return ResponseEntity.ok(response);

    }
    //getTopLevelGenre
    @GetMapping("/top-level")
    public ResponseEntity<?> getTopLevelGenres(){
        List<GenreDTO> genres = genreService.getTopLevelGenres();
        return ResponseEntity.ok(genres);

    }
    //getTotalActiveGenres
    @GetMapping("/count")
    public ResponseEntity<?> getTotalActiveGenres(){
        Long genres = genreService.getTotalActiveGenres();
        return ResponseEntity.ok(genres);

    }

    //getBookCountByGenres
    @GetMapping("/{id}/book-count")
    public ResponseEntity<?> getBookCountByGenres(@PathVariable Long id){
        Long count = genreService.getBookCountByGenre(id);
        return ResponseEntity.ok(count);

    }
}

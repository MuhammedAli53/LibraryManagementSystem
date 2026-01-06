package com.library_management_system.Repository;

import com.library_management_system.modal.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}

package com.library_management_system.Service;

import com.library_management_system.payload.dto.BookDTO;
import com.library_management_system.payload.request.BookSearchRequest;
import com.library_management_system.payload.response.PageResponse;

import java.util.List;

public interface BookService {

    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> createBooksBulk();
    BookDTO getBookById(Long bookId);
    BookDTO getBookByISBN(String isbn);
    BookDTO updateBook(Long bookId, BookDTO bookDTO);
    void deleteBook(Long bookId);
    void hardBook(Long bookId);

    PageResponse<BookDTO> searchBookWithFilters(BookSearchRequest searchRequest);

    long getTotalActiveBooks();

    long getTotalAvailableBooks();
}

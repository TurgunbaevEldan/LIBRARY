package models.service.serviceImpl;

import models.Book;
import models.Library;
import models.service.BookService;
import models.service.LibraryService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final LibraryService libraryService;

    public BookServiceImpl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        Library library = libraryService.getLibraryById(libraryId);
        library.setBook(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return libraryService.getLibraryById(libraryId).getBooks();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = libraryService.getLibraryById(libraryId );
        for (Book book:library.getBooks()) {
            if (book.getId()==bookId){
                return book;
            }
        }

        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library l:libraryService.getAllLibraries()) {
            for (Book b:getAllBooks(libraryId)) {
                if (libraryId.equals(l.getId())){
                    if (bookId.equals(b.getId())){
                        l.getBooks().remove(b);
                    }
                }
            }
        }
        return "Successfully deleted...";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library l:libraryService.getAllLibraries()) {
            if (libraryId == l.getId()){
                l.setBooks(null);
                System.out.println("Successfully deleted all books...");
            }
        }
    }
}

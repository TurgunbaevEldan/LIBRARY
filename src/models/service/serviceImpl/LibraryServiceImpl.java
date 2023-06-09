package models.service.serviceImpl;

import models.Database;
import models.Library;
import models.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private Database database = new Database();

    public LibraryServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        database.getLibraryList().addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return database.getLibraryList();
    }

    @Override
    public Library getLibraryById(Long id) {
        Library library1 = null;
        for (Library l : database.getLibraryList()) {
            if (l.getId() == id) {
                library1 = l;
            }
        }
        return library1;
    }

    @Override
    public Library updateLibrary(Long id, Library newlibrary) {
        Library library = getLibraryById(id);
        library.setName(newlibrary.getName());
        library.setAddress(newlibrary.getAddress());
        library.setBooks(newlibrary.getBooks());
        library.setReaders(newlibrary.getReaders());
        return library;
    }

    @Override
    public String deleteLibrary(Long id) {
        database.getLibraryList().remove(getLibraryById(id));
        return String.format("Library with id %d is deleted", id);
    }
}
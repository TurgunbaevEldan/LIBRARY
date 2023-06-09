package models;

import models.enums.Gender;
import models.enums.Genre;
import models.service.serviceImpl.BookServiceImpl;
import models.service.serviceImpl.LibraryServiceImpl;
import models.service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Book> booksList = new ArrayList<>(
                List.of(
                        new Book(1L, "отцы и дети", "Иван Тургенев", "+996700000000", Genre.LITERARY),
                        new Book(1L, "Не тупи", "Джен Синсеро", "+996701010101", Genre.PSYCHOLOGICAL),
                        new Book(1L, "Сделка", "Эль Кеннеди", "+996702020202", Genre.ROMANCE)
                ));

        List<Reader> readersList = new ArrayList<>(
                List.of(
                        new Reader(1L, "Eldan", "Eldan@gamil.com", "+996505050428", Gender.MALE),
                        new Reader(2L, "Amina", "Amina@gmail.com", "+996995665528", Gender.FAMElE),
                        new Reader(3L, "Aizat", "Aizat@gmail.com", "+996700000000", Gender.FAMElE),
                        new Reader(4L, "Aiturgan", "Aiturgan@gmail.com", "+996706026801", Gender.FAMElE)
                ));
        Reader reader = new Reader(3L, "Erbol", "Erbol@gamil.com", "+996505050428", Gender.MALE);


        List<Library> libraryList = new ArrayList<>(
                List.of(
                        new Library(1L, "A.Osmnov", "chuy"),
                        new Library(2L, "№14", "Микрорайон 'Аламедин-1',50a"),
                        new Library(3L, "Городская", "Жибек жолу,60"),
                        new Library(4L, "И.Раззакова", "Пр. Чынгыза Айтматова"),
                        new Library(5L, "С.Орозбековна", "7-й микрорайон,1")
                ));
        Database database = new Database();
        LibraryServiceImpl libraryService = new LibraryServiceImpl(database);
        ReaderServiceImpl readerService = new ReaderServiceImpl(database);
        BookServiceImpl bookService = new BookServiceImpl(libraryService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1 Save library <-" +
                    "\n2 Get all library <-"+
                    "\n3 Get library by id <-"+
                    "\n4 Update library <-"+
                    "\n5 Delete library <-"+
                    "\n6 Save book <-"+
                    "\n7 Get all book <-"+
                    "\n8 Get book by id "+
                    "\n9 Delete book <-"+
                    "\n10 Clear book <-"+
                    "\n11 Save reader <-"+
                    "\n12 Get all reader <- "+
                    "\n13 Get Reader by id <-"+
                    "\n14 Update reader <-"+
                    "\n15 Assign reader to library");
            int a = scanner.nextInt();
            switch (a) {

                case 1 -> System.out.println(libraryService.saveLibrary(libraryList));
                case 2 -> System.out.println(libraryService.getAllLibraries());
                case 3 -> System.out.println(libraryService.getLibraryById(1L));
                case 4 -> System.out.println(libraryService.updateLibrary(1L, new Library(1L, "Chyngiza Aitmatova", "Aitmatova", booksList, readersList)));
                case 5 -> System.out.println(libraryService.deleteLibrary(2L));
                case 6 -> System.out.println(bookService.saveBook(1L,new Book(1L,"X","c0","hr",Genre.ROMANCE)));
                case 7 -> System.out.println(bookService.getAllBooks(1L));
                case 8 -> System.out.println(bookService.getBookById(1L,1L));
                case 9-> System.out.println(bookService.deleteBook(1L,1L));
                case 10->bookService.clearBooksByLibraryId(1L);
                case 11->readerService.saveReader(new Reader(1L,"Eldan","Eldan@gmail.com","424242424",Gender.MALE));
                case 12-> System.out.println(readerService.getAllReaders());
                case 13-> System.out.println(readerService.getReaderById(1L));
                case 14-> System.out.println(readerService.updateReader(1L,new Reader(2L,"Samat","Samat@gmail.com","gjeohoeje",Gender.MALE)));
                case 15->readerService.assignReaderToLibrary(1L,1L);
                default -> System.err.println("Ошибаешься брат...");
            }
        }
    }
}
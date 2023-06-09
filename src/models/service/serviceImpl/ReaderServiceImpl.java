package models.service.serviceImpl;

import models.Database;
import models.Library;
import models.Reader;
import models.service.LibraryService;
import models.service.ReaderService;

import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {

    private final Database database;

    public ReaderServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveReader(Reader reader) {
       database.getReaderList().add(reader);
        System.out.println(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return database.getReaderList();
    }

    @Override
    public Reader getReaderById(Long id) {
        boolean cycle;
        for (Reader re : getAllReaders()) {
            if (re.getId() == id) {
                return re;
            } else {
                cycle = false;
                System.err.println("Не найдено...");
            }
        }


        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
//        boolean cycle = false;
//        for (Reader r : database.getReaderList()) {
//            if (r.getId()==id) {
//                r.setId(reader.getId());
//                r.setEmail(reader.getEmail());
//                r.setGender(reader.getGender());
//                r.setFullName(reader.getFullName());
//                r.setPhoneNumber(reader.getPhoneNumber());
//                System.out.print("New Reader: ");
//                System.out.println(reader);
//                System.err.println(database.getReaderList());
//            }
//            else {
//                cycle = true;
//            }
//        }
//        if (cycle){
//            System.out.println("Не найдено");
//        }
//        return reader;
        for (int i = 0; i < database.getReaderList().size(); i++) {
            if (database.getReaderList().get(i).getId()==id){
                database.getReaderList().get(i).setId(reader.getId());
                database.getReaderList().get(i).setFullName(reader.getFullName());
                database.getReaderList().get(i).setPhoneNumber(reader.getPhoneNumber());
                database.getReaderList().get(i).setEmail(reader.getEmail());
                database.getReaderList().get(i).setGender(reader.getGender());
            }
        }return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {

    }
}

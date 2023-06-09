package models;

import models.enums.Genre;

public class Book {
        private long id;
        private String name;
        private String author;
        private String PhoneNumber;
        private Genre genre;


        public Book(long id, String name, String author, String phoneNumber, Genre genre) {
                this.id = id;
                this.name = name;
                this.author = author;
                PhoneNumber = phoneNumber;
                this.genre = genre;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getPhoneNumber() {
                return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                PhoneNumber = phoneNumber;
        }

        public Genre getGenre() {
                return genre;
        }

        public void setGenre(Genre genre) {
                this.genre = genre;
        }

        @Override
        public String toString() {
                return "\nBook:  " +
                        "Id:  " + id +
                        "Name:  " + name +
                        "Author:  " + author +
                        "PhoneNumber:  " + PhoneNumber +
                        "Genre:  " + genre;
        }
}

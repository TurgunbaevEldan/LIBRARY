package models;

import models.enums.Gender;

public class Reader {
    private long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Gender gender;

    public Reader(long id, String fullName, String email, String phoneNumber, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\n< Reader >  " +
                "Id:  " + id +
                "FullName:  " + fullName +
                "Email:  " + email +
                "PhoneNumber:  " + phoneNumber +
                "Gender:  " + gender ;
    }
}

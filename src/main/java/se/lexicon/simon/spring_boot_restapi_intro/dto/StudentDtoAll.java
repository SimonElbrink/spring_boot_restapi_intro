package se.lexicon.simon.spring_boot_restapi_intro.dto;

import java.time.LocalDate;

// A View, That contains all the fields.
public class StudentDtoAll {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String psn;
    private String address;

    public StudentDtoAll() {
    }

    public StudentDtoAll(String id, String firstName, String lastName, LocalDate birthDate, String psn, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.psn = psn;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package se.lexicon.simon.spring_boot_restapi_intro.dto;

import java.time.LocalDate;

// is usually for creating/updating
//Simple or POJO object
public class StudentFormDto {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String psn;
    private String address;

    public StudentFormDto() {
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

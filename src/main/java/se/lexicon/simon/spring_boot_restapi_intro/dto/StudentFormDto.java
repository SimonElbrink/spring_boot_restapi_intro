package se.lexicon.simon.spring_boot_restapi_intro.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

// is usually for creating/updating
//Simple or POJO object
public class StudentFormDto {

    private final String NOT_EMPTY = "Can not be empty.";
    private final String SIZE_BETWEEN_2_30 = "Need to contain between 2 and 30 Characters.";

    @NotBlank(message = NOT_EMPTY)
    @Size(min = 2, max = 30, message = SIZE_BETWEEN_2_30)
    private String firstName;

    @NotBlank(message = NOT_EMPTY)
    @Size(min = 2, max = 30, message = SIZE_BETWEEN_2_30)
    private String lastName;

    @NotNull(message = "Need to specify date of birth.")
    @PastOrPresent (message = "Need to be in the past or today.")
    private LocalDate birthDate;

    @NotBlank(message = NOT_EMPTY)
    @Pattern( message = "Pattern not matching.",
             regexp = "^[0-9]{6}-[0-9pPtTfF][0-9]{3}$") //https://www.regexlib.com/REDetails.aspx?regexp_id=2524
    private String psn;

    @NotBlank(message = NOT_EMPTY)
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

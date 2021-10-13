package se.lexicon.simon.spring_boot_restapi_intro.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String studentId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String psn;
    private String address;


    public Student() {
    }

    public Student(String studentId, String firstName, String lastName, LocalDate birthDate, String psn, String address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.psn = psn;
        this.address = address;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getStudentId(), student.getStudentId()) && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getBirthDate(), student.getBirthDate()) && Objects.equals(getPsn(), student.getPsn()) && Objects.equals(getAddress(), student.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName(), getBirthDate(), getPsn(), getAddress());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", psn='" + psn + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

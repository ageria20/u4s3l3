package entities;


import enums.GenderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name="Person")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column (nullable = false)
    private String first_name;

    @Column (nullable = false)
    private String last_name;

    @Column
    private String mail;

    @Column (nullable = false)
    private LocalDate birthDate;


    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType gender;


    @OneToMany(mappedBy = "person")
    private List<Partecipation> partecipationList;

    public Person() {
    }

    public Person(String first_name, String last_name, String mail, LocalDate birthDate, GenderType gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<Partecipation> getPartecipationList() {
        return partecipationList;
    }

    public void setPartecipationList(List<Partecipation> partecipationList) {
        this.partecipationList = partecipationList;
    }
}

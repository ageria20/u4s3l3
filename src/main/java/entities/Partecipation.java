package entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "partecipation")
public class Partecipation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusType status;



    public Partecipation() {
    }

    public Partecipation(Person person, Event event, StatusType status) {
    this.person = person;
    this.event = event;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}

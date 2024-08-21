package entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "partecipation")
public class Partecipation {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Person person_id;

    @Column
    private Event event_id;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Partecipation() {
    }

    public Partecipation(Person person_id, Event event_id, StatusType status) {
        this.person_id = person_id;
        this.event_id = event_id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Event getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Event event_id) {
        this.event_id = event_id;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}

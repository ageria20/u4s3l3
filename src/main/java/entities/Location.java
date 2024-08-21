package entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "location")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String city;

    @OneToMany (mappedBy = "location_id")
    private List<Event> events;

    public Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

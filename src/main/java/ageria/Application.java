package ageria;

import dao.EventDAO;
import dao.LocationDAO;
import dao.PartecipationDAO;
import dao.PersonDAO;
import entities.*;
import enums.EventType;
import enums.GenderType;
import enums.StatusType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l3");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO pd = new PersonDAO(em);
        PartecipationDAO partD = new PartecipationDAO(em);

        Event evento1 = new Event(
                "Conference on AI",
                LocalDate.of(2024, 9, 10),
                "An event discussing the latest advancements in Artificial Intelligence.",
                EventType.PUBLIC,
                200
        );

        Event evento2 = new Event(
                "Music Festival",
                LocalDate.of(2024, 8, 25),
                "A vibrant music festival featuring live bands and DJs.",
                EventType.PUBLIC,
                500
        );

        Event evento3 = new Event(
                "Art Exhibition",
                LocalDate.of(2024, 11, 5),
                "A showcase of contemporary art from emerging artists.",
                EventType.PRIVATE,
                150
        );

        Event evento4 = new Event(
                "Startup Pitch Event",
                LocalDate.of(2024, 12, 15),
                "A platform for startups to pitch their ideas to investors.",
                EventType.PRIVATE,
                100
        );

        Person ross = new Person(
                "Ross",
                "Geller",
                "ross.geller@friends.com",
                LocalDate.of(1967, 10, 18),
                GenderType.MALE
        );


        Person rachel = new Person(
                "Rachel",
                "Green",
                "rachel.green@friends.com",
                LocalDate.of(1969, 5, 5),
                GenderType.FEMALE
        );


        Person chandler = new Person(
                "Chandler",
                "Bing",
                "chandler.bing@friends.com",
                LocalDate.of(1968, 4, 8),
                GenderType.MALE
        );


        Person monica = new Person(
                "Monica",
                "Geller",
                "monica.geller@friends.com",
                LocalDate.of(1964, 3, 22),
                GenderType.FEMALE
        );

        Location location1 = new Location("Central Park", "New York");
        Location location2 = new Location("Colosseum", "Rome");
        Location location3 = new Location("Eiffel Tower", "Paris");
        Location location4 = new Location("Sydney Opera House", "Sydney");

        Person personFromDb = pd.getById("4726a28c-b81b-424e-ad97-1ea7bd37e688");
        Person person2FromDb = pd.getById("ca9f4f5d-1a9d-41b8-98c7-bc86e38c2d4c");

        Event eventFromDb = ed.getById("24b7c9ff-426a-4d3a-8473-ac9311b21337");
        Event event2FromDb = ed.getById("9f6e8038-7504-4bb6-a793-1f7d76cd30b5");


        Partecipation partConfirmed = new Partecipation(personFromDb, eventFromDb, StatusType.CONFIRMED );
        Partecipation partNotConfirmed = new Partecipation(person2FromDb, event2FromDb, StatusType.NOT_CONFIRMED );

        /*pd.save(ross);
        pd.save(rachel);
        pd.save(chandler);
        pd.save(monica);*/

        /*ld.save(location1);
        ld.save(location2);
        ld.save(location3);
        ld.save(location4);*/


      /*ed.save(evento1);
      ed.save(evento2);
      ed.save(evento3);
      ed.save(evento4);*/

        partD.save(partConfirmed);
        partD.save(partNotConfirmed);

        personFromDb.getPartecipationList().forEach(System.out::println);


        System.out.println("TUTTO OK!");
    }
}

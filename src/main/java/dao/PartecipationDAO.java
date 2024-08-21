package dao;

import entities.Partecipation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipationDAO {
    private EntityManager em;

    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipation event){
        EntityTransaction transaction = em.getTransaction(); // Chiediamo all'entity la transazione
        transaction.begin();
        em.persist(event); // Aggiungiamo il dato al Persist Context, ma ancora non risulta salvato
        // Conlucdiamo la transazione, salvando il dato nel DB
        transaction.commit(); // dato salavto
    }


    public Partecipation getById(String id){
        Partecipation found = em.find(Partecipation.class, UUID.fromString(id));
        if( found == null) throw new RuntimeException("Evento non trovato");
        else return found;
    }

    public void delete(String id){
        Partecipation eventToDelete = getById(id); // Cerchiamo l'id del dato
        EntityTransaction transaction = em.getTransaction(); // Chidiamo all'eneity di aprire una transaction
        transaction.begin(); // iniziamo la Transaction
        em.remove(eventToDelete); // Rimuoviamo il dato dal Persist Context (qui ancora non risulta eliminato dal Database)
        transaction.commit(); // Qui il dato è rimosso.
    }
}

package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.entities.Concerto;
import org.example.entities.ConcertoType;
import org.example.entities.Evento;
import org.example.entities.PartitaDiCalcio;
import org.example.exceptions.NotFoundException;

import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(evento);

        tx.commit();

        System.out.println("EVENTO " + evento.getTitolo() + " SALVATO CORRETTAMENTE");
    }

    public Evento getById(long id) {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) throw new NotFoundException(id);
        return evento;
    }

    public void delete(long id) {
        Evento trovato = this.getById(id);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(trovato);

        tx.commit();

        System.out.println("EVENTO " + trovato.getTitolo() + " ELIMINATO CON SUCCESSO");
    }

    public List<Boolean> getConcertiStreaming() {
        TypedQuery<Boolean> query = em.createQuery("SELECT c.streaming FROM Concerto c", Boolean.class);
        return query.getResultList();
    }

    public List<Concerto> getConcertiGenere(ConcertoType genere) {
        TypedQuery<Concerto> q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        q.setParameter("genere", genere);
        return q.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> p = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return p.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> p = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return p.getResultList();
    }
}

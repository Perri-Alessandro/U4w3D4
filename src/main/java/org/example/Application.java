package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDao;
import org.example.dao.PersonaDao;
import org.example.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("U4w3D4");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManager em = emFactory.createEntityManager();
        EventoDAO eventoDao = new EventoDAO(em);
        LocationDAO locatDao = new LocationDAO(em);
        PersonaDao personaDAO = new PersonaDao(em);
        PartecipazioneDao partDAO = new PartecipazioneDao(em);

//
//        Location moena = new Location("a funghi nel bosco", "Moena");


        Partecipazione eccomi = null;
//        Evento test = new Evento("a funghi"
//                , LocalDate.of(2024, 5, 01)
//                , "hytnhntrnrfewrzgrehrth", 6, EventoType.PUBBLICO, (List<Partecipazione>) eccomi, moena);  OCCHIO

        System.out.println("Hello World!");

//        eventoDao.save(test);      OCCHIO


        Persona prima = new Persona("Federico", "Verdi", "verdif@gmail.com", LocalDate.of(1988, 3, 14), PersonaType.M, (List<Partecipazione>) eccomi);
        personaDAO.save(prima);


//        partDAO.save(eccomi);

        Location nuova = new Location("Concerto xyz", "Milano");
        locatDao.save(nuova);
        Concerto pop = new Concerto("titolo1", LocalDate
                .of(2024, 5, 10), "concerto per fdvfvfdd d df", 95000, EventoType
                .PUBBLICO, (List<Partecipazione>) eccomi, nuova, ConcertoType.POP, true);


        eccomi = new Partecipazione(PartecipazioneType.DA_CONFERMARE, prima, pop);

        eventoDao.save(pop);

//        Evento trova = null;
//        try {
//            System.out.println("----------------------- INSERISCI 1 ID PER CERCARE 1 EVENTO NEL DATABASE ----------------------------");
//            int id = Integer.parseInt(sc.nextLine());
//            trova = eventoDao.getById(id);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println(trova.getTitolo());
//        }

//        Evento cancella = null;
//        try {
//            System.out.println("------------------------------ INSERISCI L'ID DI ELEMENTO DA ELIMINARE ----------------------------------");
//            int id = Integer.parseInt(sc.nextLine());
//            eventoDao.delete(id);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println(cancella.getTitolo());
//        }


        em.close();
        emFactory.close();
        sc.close();
    }
}

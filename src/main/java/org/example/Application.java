package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDao;
import org.example.dao.PersonaDao;
import org.example.entities.Location;
import org.example.entities.Partecipazione;
import org.example.entities.Persona;
import org.example.entities.PersonaType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("U4w3D3");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManager em = emFactory.createEntityManager();
        EventoDAO eventoDao = new EventoDAO(em);
        LocationDAO locatDao = new LocationDAO(em);
        PersonaDao personaDAO = new PersonaDao(em);
        PartecipazioneDao partDAO = new PartecipazioneDao(em);


        Location moena = new Location("a funghi nel bosco", "Moena");

        locatDao.save(moena);

        Partecipazione eccomi = null;
//        Evento test = new Evento("a funghi"
//                , LocalDate.of(2024, 5, 01)
//                , "hytnhntrnrfewrzgrehrth", 6, EventoType.PUBBLICO, (List<Partecipazione>) eccomi, moena);  OCCHIO

        System.out.println("Hello World!");

//        eventoDao.save(test);      OCCHIO


        Persona prima = new Persona("Federico", "Verdi", "verdif@gmail.com", LocalDate.of(1988, 3, 14), PersonaType.M, (List<Partecipazione>) eccomi);
        personaDAO.save(prima);

//        eccomi = new Partecipazione(PartecipazioneType.DA_CONFERMARE, prima, test);   OCCHIO

        partDAO.save(eccomi);


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

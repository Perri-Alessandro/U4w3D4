package org.example.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("partita_di_calcio") // <-- Cambia il valore della discriminator column
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.golCasa > p.golOspite")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.golOspite > p.golCasa")
public class PartitaDiCalcio extends Evento {

    public String squadraCasa;

    public String squadraOspite;

    public String squadraVincente;

    public int golCasa;

    public int golOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate data, String descrizione, long maxPartecipanti, EventoType tipoEvento, List<Partecipazione> partecipazioni, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int golCasa, int golOspite) {
        super(titolo, data, descrizione, maxPartecipanti, tipoEvento, partecipazioni, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPartecipanti=" + maxPartecipanti +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                ", squadra_di_casa=" + squadraCasa +
                ", squadra_ospite=" + squadraOspite +
                ", squadra_vincente=" + squadraVincente +
                ", gol_squadra_di_casa=" + golCasa +
                ", gol_squadra_ospite=" + golOspite +
                '}';
    }
}

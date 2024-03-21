package org.example.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("gara_di_atletica") // <-- Cambia il valore della discriminator column
public class GaraDiAtletica extends Evento {
    public Persona atleti;

    public Persona vincitore;


    public GaraDiAtletica() {
    }

    ;

    public GaraDiAtletica(String titolo, LocalDate data, String descrizione, long maxPartecipanti, EventoType tipoEvento, List<Partecipazione> partecipazioni, Location location, Persona atleti, Persona vincitore) {
        super(titolo, data, descrizione, maxPartecipanti, tipoEvento, partecipazioni, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Persona getAtleti() {
        return atleti;
    }

    public void setAtleti(Persona atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPartecipanti=" + maxPartecipanti +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}

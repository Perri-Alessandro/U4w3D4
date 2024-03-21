package org.example.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("concerto") // <-- Cambia il valore della discriminator column
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    public ConcertoType genere;

    public Boolean streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate data, String descrizione, long maxPartecipanti, EventoType tipoEvento, List<Partecipazione> partecipazioni, Location location, ConcertoType genere, Boolean streaming) {
        super(titolo, data, descrizione, maxPartecipanti, tipoEvento, partecipazioni, location);
        this.genere = genere;
        this.streaming = streaming;
    }

    public ConcertoType getGenere() {
        return genere;
    }

    public void setGenere(ConcertoType genere) {
        this.genere = genere;
    }

    public Boolean getStreaming() {
        return streaming;
    }

    public void setStreaming(Boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
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

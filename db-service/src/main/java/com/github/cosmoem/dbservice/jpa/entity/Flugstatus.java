package com.github.cosmoem.dbservice.jpa.entity;


import javax.persistence.*;
import java.time.*;


@Entity(name = "flugstatus")
public class Flugstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "flugnummer")
    private String flugnummer;

    @Column(name = "airline")
    private String airline;

    @Column(name = "von")
    private String von;

    @Column(name = "nach")
    private String nach;

    @Column(name = "flugdatum")
    private String flugdatum;

    @Column(name = "uhrzeit")
    private LocalTime uhrzeit;

    public Flugstatus(final String flugnummer, final String airline, final String von, final String nach, final String flugdatum, final LocalTime uhrzeit) {
        this.flugnummer = flugnummer;
        this.airline = airline;
        this.von = von;
        this.nach = nach;
        this.flugdatum = flugdatum;
        this.uhrzeit = uhrzeit;
    }

    public Flugstatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFlugnummer() {
        return flugnummer;
    }

    public void setFlugnummer(final String flugnummer) {
        this.flugnummer = flugnummer;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public String getVon() {
        return von;
    }

    public void setVon(final String von) {
        this.von = von;
    }

    public String getNach() {
        return nach;
    }

    public void setNach(final String nach) {
        this.nach = nach;
    }

    public String getFlugdatum() {
        return flugdatum;
    }

    public void setFlugdatum(final String flugdatum) {
        this.flugdatum = flugdatum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(final LocalTime uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
}

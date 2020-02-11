package com.github.cosmoem.dbservice;


import javax.persistence.*;
import java.util.Set;
import java.time.*;
import java.util.Date;


@Entity
@Table(name = "flugstatus")
public class Flugstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
    private Date flugdatum;

    @Column(name = "uhrzeit")
    private LocalTime uhrzeit;

    public Flugstatus(final String flugnummer, final String airline, final String von, final String nach, final Date flugdatum, final LocalTime uhrzeit) {
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

    public Date getFlugdatum() {
        return flugdatum;
    }

    public void setFlugdatum(final Date flugdatum) {
        this.flugdatum = flugdatum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(final LocalTime uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
}

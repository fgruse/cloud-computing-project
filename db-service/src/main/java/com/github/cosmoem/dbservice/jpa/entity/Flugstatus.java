package com.github.cosmoem.dbservice.jpa.entity;


import javax.persistence.*;
import java.util.Set;
import java.time.*;
import java.util.Date;


@Entity
@Table(name = "flugstatus")
public class Flugstatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Flugnummer")
    private String Flugnummer;

    @Column(name = "Airline")
    private String Airline;

    @Column(name = "von")
    private String von;

    @Column(name = "nach")
    private String nach;

    @Column(name = "Flugdatum")
    private Date Flugdatum;

    @Column(name = "Uhrzeit")
    private LocalTime Uhrzeit;



    public Flugstatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlugnummer() {
        return Flugnummer;
    }

    public void setFlugnummer(String flugnummer) {
        Flugnummer = flugnummer;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getNach() {
        return nach;
    }

    public void setNach(String nach) {
        this.nach = nach;
    }

    public Date getFlugdatum() {
        return Flugdatum;
    }

    public void setFlugdatum(Date flugdatum) {
        Flugdatum = flugdatum;
    }

    public LocalTime getUhrzeit() {
        return Uhrzeit;
    }

    public void setUhrzeit(LocalTime uhrzeit) {
        Uhrzeit = uhrzeit;
    }

}

package com.github.cosmoem.dbservice.web.model;

import java.time.LocalTime;
import java.util.Date;

public class FlugstatusModel {

    private int id;
    private String flugnummer;
    private String airline;
    private String von;
    private String nach;
    private String flugdatum;
    private LocalTime uhrzeit;

    public FlugstatusModel() {
    }

    public FlugstatusModel(final int id, final String flugnummer, final String airline, final String von, final String nach, final String flugdatum,
            final LocalTime uhrzeit) {
        this.id = id;
        this.flugnummer = flugnummer;
        this.airline = airline;
        this.von = von;
        this.nach = nach;
        this.flugdatum = flugdatum;
        this.uhrzeit = uhrzeit;
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

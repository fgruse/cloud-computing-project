package com.github.cosmoem.uiservice.handlingformsubmission;

import java.time.LocalTime;
import java.util.Date;

public class Flug {

    private int id;
    private String flugnummer;
    private String airline;
    private String von;
    private String nach;
    private Date flugdatum;
    private LocalTime uhrzeit;

    public Flug(final int id, final String flugnummer, final String airline, final String von, final String nach, final Date flugdatum,
            final LocalTime uhrzeit) {
        this.id = id;
        this.flugnummer = flugnummer;
        this.airline = airline;
        this.von = von;
        this.nach = nach;
        this.flugdatum = flugdatum;
        this.uhrzeit = uhrzeit;
    }

    public Flug() {

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

    @Override
    public String toString() {
        return "Flug{" +
                "id=" + id +
                ", flugnummer='" + flugnummer + '\'' +
                ", airline='" + airline + '\'' +
                ", von='" + von + '\'' +
                ", nach='" + nach + '\'' +
                ", flugdatum=" + flugdatum +
                ", uhrzeit=" + uhrzeit +
                '}';
    }
}

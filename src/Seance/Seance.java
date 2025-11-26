package Seance;

import Film.Film;

import java.sql.Connection;
import java.sql.DriverManager;

public class Seance {
    private String dateSeance;
    private String horaire;
    private float prix ;
    private int capaciteMaximale;
    private String salle;
    private int filmid;

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Seance(String dateSeance, String horaire, float prx, int capaciteMaximale, String salle, int film){
        this.dateSeance = dateSeance;
        this.horaire = horaire;
        this.prix = prx;
        this.capaciteMaximale = capaciteMaximale;
        this.salle = salle;
        this.filmid = film;
    }



    public String getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public int getFilm() {
        return filmid;
    }

    public void setFilm(int film) {
        this.filmid = film;
    }

}

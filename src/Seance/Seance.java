package Seance;

import Film.Film;

import java.sql.Connection;
import java.sql.DriverManager;

public class Seance {
    static int idgenerator = 1;
    private int seanceId ;
    private String dateSeance;
    private String horaire;
    private float prix ;
    private int capaciteMaximale;
    private String salle;
    private Film film;

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Seance(String dateSeance, String horaire, float prx, int capaciteMaximale, String salle, Film film){
        this.seanceId = idgenerator++;
        this.dateSeance = dateSeance;
        this.horaire = horaire;
        this.prix = prx;
        this.capaciteMaximale = capaciteMaximale;
        this.salle = salle;
        this.film = film;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    public void afficherFilm(){
        System.out.printf("Film title : %s \nfilm duree : %s\nfilm categorie : %s\n",film.getTitre(),film.getDuree(),film.getCategorie());
    }
}

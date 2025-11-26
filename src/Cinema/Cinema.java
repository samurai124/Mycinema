package Cinema;
import Data_base.DataBase;
import java.util.Scanner;
import Film.Film;
import Seance.Seance;

public class Cinema {
    static DataBase db = new DataBase();
    static Scanner input = new Scanner(System.in);
    public void ajouterFilm(){
        String ajouter = "oui";
        do {
            System.out.print("\nEntrer le fiml titre : ");
            String titre = input.nextLine();
            System.out.print("\nEntrer le film duree : ");
            String duree = input.nextLine();
            System.out.print("\nEntrer le film categorie : ");
            String categorie = input.nextLine();
            Film f = new Film(titre, duree, categorie);
            db.ajouterFilm(f);
            System.out.println("Film ajouter !!");
            System.out.print("tu veux ajouter un autre livre ? (oui/non) : ");
            ajouter = input.nextLine();
        }while (ajouter.equals("oui"));
    }
    public void supprimerFilm(){
        db.getFilmsFromDB();
        System.out.print("Entrer livre id : ");
        int filmid = input.nextInt();
        db.supprimerFilmfromdb(filmid);
    }
    public void ajouterSeance(){
        String ajouter = "oui";
        do {
            System.out.print("Enter la date seance : ");
            String dateSeance = input.nextLine();
            System.out.print("Enter l'horaire : ");
            String horaire = input.nextLine();
            System.out.print("Enter le prix : ");
            int prix = input.nextInt();
            System.out.print("Enter la capaciteMaximale : ");
            int capaciteMaximale = input.nextInt();
            System.out.print("Enter l'horaire : ");
            String salle = input.nextLine();
            db.getFilmsFromDB();
            System.out.print("Enter le filmId : ");
            int filmid = input.nextInt();
            input.nextLine();
            System.out.print("tu veux ajouter un autre livre ? (oui/non) : ");
            ajouter = input.nextLine();
            Seance s = new Seance(dateSeance,horaire,prix,capaciteMaximale,salle,filmid);
            db.ajouteSeance(s);
        }while (ajouter.equals("oui"));
    }
    public void supprimerSeance() {
        db.getSeancesFromDB2();
        System.out.print("Entrer seance id : ");
        int seanceId = input.nextInt();
        input.nextLine();
        db.supprimerSeanceFromDB(seanceId);
    }

}

package Cinema;
import Data_base.DataBase;
import java.util.Scanner;
import Film.Film;
import Seance.Seance;
import Spectateur.Spectateur;
import Ticket.Ticket;

public class Cinema {
    static DataBase db = new DataBase();
    static Scanner input = new Scanner(System.in);
    public void ajouterFilm(){
        String ajouter = "oui";
        do {
            input.nextLine();
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
    public void afficheLivres(){
        db.getFilmsFromDB();
    }
    public void ajouterSeance(){
        String ajouter = "oui";
        do {
            input.nextLine();
            System.out.print("\nEnter la date seance : ");
            String dateSeance = input.nextLine();
            System.out.print("\nEnter l'horaire : ");
            String horaire = input.nextLine();
            System.out.print("\nEnter le prix : ");
            int prix = input.nextInt();
            System.out.print("\nEnter la capaciteMaximale : ");
            int capaciteMaximale = input.nextInt();
            input.nextLine();
            System.out.print("\nEnter la salle : ");
            String salle = input.nextLine();
            db.getFilmsFromDB();
            System.out.print("\nEnter le filmId : ");
            int filmid = input.nextInt();
            input.nextLine();
            System.out.print("\ntu veux ajouter une autre seance ? (oui/non) : ");
            ajouter = input.nextLine();
            Seance s = new Seance(dateSeance,horaire,prix,capaciteMaximale,salle,filmid);
            db.ajouteSeance(s);
        }while (ajouter.equals("oui"));
    }
    public void supprimerSeance() {
        db.getSeancesFromDB2();
        System.out.print("\nEntrer seance id : ");
        int seanceId = input.nextInt();
        input.nextLine();
        db.supprimerSeanceFromDB(seanceId);
    }
    public void afficherSeances(){
        db.getSeancesFromDB2();
    }
    public String AjouterSpectateur(){
        //nom
        input.nextLine();
        System.out.print("\n Entrer votre nom : ");
        String nom = input.nextLine();
        // email
        System.out.print("Entrer votre email : ");
        String email = input.nextLine();
        Spectateur s = new Spectateur(nom , email);
        db.ajouterSpectateurToDatabase(s);
        return nom;
    }
    public void CreateTicket(){
        // nomSpecateur
        String nom = AjouterSpectateur();
        // idSpectateur
        int id = db.getSpectateurId(nom);
        // seance id
        db.getSeancesFromDB2();
        System.out.print("\nEntrer la seance id : ");
        int seanceId = input.nextInt();
        // seance prix
        float prix = db.getSeancePrix(seanceId);
        Ticket t = new Ticket(prix,seanceId,id);
        db.ajouterTicket(t);
        db.afficherTicketsParSpectateur(id);
    }

    public void menu(){
        int choix = 0;
        do {
            System.out.print("1 ==> ajouter un film\n2 ==> supprimer un film\n3 ==> afficher tous les film\n4 ==> ajouter une seance\n5 ==> supprimer une seance\n6 ==> afficher touts les seances\n0 ==> pour quitter");
            System.out.printf("\nEntrer votre choix : ");
            choix = input.nextInt();
            switch (choix){
                case 1 -> ajouterFilm();
                case 2 -> supprimerFilm();
                case 3 -> afficheLivres();
                case 4 -> ajouterSeance();
                case 5 -> supprimerSeance();
                case 6 -> afficherSeances();
                default -> System.out.println("!!");
            }
        }while (choix != 0);
    }
    public void cinema(){
        int choix = 0;
        do {
            System.out.print("1 ==> Veux-tu un billet\n2 ==> Admin menu\n0 ==> Quitter");
            System.out.print("\nENtrer votre choix : ");
            choix = input.nextInt();
            switch (choix){
                case 1 -> CreateTicket();
                case 2 -> menu();
                case 3 -> System.out.print("\n !!!!!!!!!");
                default -> System.out.print("\n invalid");
            }
        }while (choix !=  0);
    }
}

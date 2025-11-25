package Cinema;
import Data_base.DataBase;
import java.util.Scanner;
import Film.Film;

public class Cinema {
    static DataBase db = new DataBase();
    static Scanner input = new Scanner(System.in);
    public void ajouterFilm(){
        System.out.print("\nEntrer le fiml titre : ");
        String titre = input.nextLine();
        System.out.print("\nEntrer le film duree : ");
        String duree = input.nextLine();
        System.out.print("\nEntrer le film categorie : ");
        String categorie = input.nextLine();
        Film f = new Film(titre,duree,categorie);
        db.ajouterFilm(f);
        System.out.println("Film ajouter !!");
    }
}

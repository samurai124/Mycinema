import Cinema.Cinema;
import Seance.Seance;
import Film.Film;
import Data_base.DataBase;



public class Main {


    public static void main(String[] args) {
        Cinema c = new Cinema();
        DataBase db = new DataBase();
        Film f1 = new Film("lotr","3:30","sci-fi");
        Film f2 = new Film("lotr","3:30","sci-fi");

        Seance s1 = new Seance("10-11-2025","10:15",25,100,"sall10",f1);
        Seance s2 = new Seance("10-11-2025","10:15",25,100,"sall10",f2);

        //c.ajouterFilm();

        //db.getFilmsFromDB();









    }
}

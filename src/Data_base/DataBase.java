package Data_base;
import Film.Film;
import Seance.Seance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBase {
     public void ajouterFilm(Film film) {
        String ajouter_film_sql = "INSERT INTO films(filmId, titre, duree, categorie) VALUES (?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sg_cinema",
                    "root",
                    ""
            );
            PreparedStatement ps = con.prepareStatement(ajouter_film_sql);
            ps.setInt(1, film.getFilmId());
            ps.setString(2, film.getTitre());
            ps.setString(3, film.getDuree());
            ps.setString(4, film.getCategorie());
            ps.executeUpdate();
            System.out.println("Film inserted successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void ajouteSeance(Seance seance){
        String ajouter_seance_sql = "INSERT INTO seances (seanceId, dateSeance, horaire, prix, capaciteMaximale, salle, filmId) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sg_cinema",
                    "root",
                    ""
            );
            PreparedStatement ps = con.prepareStatement(ajouter_seance_sql);
            ps.setInt(1, seance.getSeanceId());
            ps.setString(2, seance.getDateSeance());
            ps.setString(3, seance.getHoraire());
            ps.setFloat(4, seance.getPrix());
            ps.setInt(5,seance.getCapaciteMaximale());
            ps.setString(6,seance.getSalle());
            ps.setInt(7,seance.getFilm().getFilmId());
            ps.executeUpdate();
            System.out.println("Seance inserted successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getFilmsFromDB() {
        String getfilms = "SELECT * FROM films";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sg_cinema",
                    "root",
                    ""
            );
            PreparedStatement ps = con.prepareStatement(getfilms);
            ResultSet rs = ps.executeQuery();

            // Iterate over the ResultSet
            while (rs.next()) {
                System.out.println("Film ID: " + rs.getInt("filmId"));
                System.out.println("Titre: " + rs.getString("titre"));
                System.out.println("Durée: " + rs.getString("duree"));
                System.out.println("Catégorie: " + rs.getString("categorie"));
                System.out.println("---------------------------");
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getSeancesFromDB(){
        String getSeances = "SELECT * FROM seances";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sg_cinema",
                    "root",
                    ""
            );
            PreparedStatement ps = con.prepareStatement(getSeances);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("seanceId : " + rs.getInt("seanceId"));
                System.out.println("dateSeance: " + rs.getString("dateSeance"));
                System.out.println("horaire: " + rs.getString("horaire"));
                System.out.println("prix : "+rs.getFloat("prix"));
                System.out.println("capaciteMaximale : "+rs.getInt("capaciteMaximale"));
                System.out.println("salle: " + rs.getString("salle"));
                System.out.println("Fiml id : "+rs.getInt("filmId"));
                System.out.println("---------------------------");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getSeancesFromDB2() {
        String getSeances = "SELECT seances.seanceId, seances.dateSeance, seances.horaire, seances.prix, seances.capaciteMaximale, seances.salle, films.titre " +
                "FROM seances " +
                "INNER JOIN films ON seances.filmId = films.filmId";

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sg_cinema",
                    "root",
                    ""
            );
            PreparedStatement ps = con.prepareStatement(getSeances);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Seance ID : " + rs.getInt("seanceId"));
                System.out.println("Date Seance: " + rs.getString("dateSeance"));
                System.out.println("Horaire: " + rs.getString("horaire"));
                System.out.println("Prix : " + rs.getFloat("prix"));
                System.out.println("Capacité Maximale : " + rs.getInt("capaciteMaximale"));
                System.out.println("Salle: " + rs.getString("salle"));
                System.out.println("Film Titre : " + rs.getString("titre"));
                System.out.println("---------------------------");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int menu(){
         
         return 0;

    }




}

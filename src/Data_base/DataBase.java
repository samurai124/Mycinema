package Data_base;

import DBconnection.DBconnection;
import Film.Film;
import Seance.Seance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

    public void ajouterFilm(Film film) {
        String ajouter_film_sql = "INSERT INTO films(titre, duree, categorie) VALUES (?,?,?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(ajouter_film_sql)) {

            ps.setString(1, film.getTitre());
            ps.setString(2, film.getDuree());
            ps.setString(3, film.getCategorie());

            ps.executeUpdate();
            System.out.println("Film inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ajouteSeance(Seance seance) {
        String sql = "INSERT INTO seances (dateSeance, horaire, prix, capaciteMaximale, salle, filmId) VALUES (?,?,?,?,?,?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, seance.getDateSeance());
            ps.setString(2, seance.getHoraire());
            ps.setFloat(3, seance.getPrix());
            ps.setInt(4, seance.getCapaciteMaximale());
            ps.setString(5, seance.getSalle());
            ps.setInt(6, seance.getFilm());

            ps.executeUpdate();
            System.out.println("Seance inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getFilmsFromDB() {
        String sql = "SELECT * FROM films";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("Film ID: " + rs.getInt("filmId"));
                System.out.println("Titre: " + rs.getString("titre"));
                System.out.println("Durée: " + rs.getString("duree"));
                System.out.println("Catégorie: " + rs.getString("categorie"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getSeancesFromDB() {
        String sql = "SELECT * FROM seances";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("Seance ID: " + rs.getInt("seanceId"));
                System.out.println("Date: " + rs.getString("dateSeance"));
                System.out.println("Horaire: " + rs.getString("horaire"));
                System.out.println("Prix: " + rs.getFloat("prix"));
                System.out.println("Capacité: " + rs.getInt("capaciteMaximale"));
                System.out.println("Salle: " + rs.getString("salle"));
                System.out.println("Film ID: " + rs.getInt("filmId"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getSeancesFromDB2() {
        String sql =
                "SELECT seances.seanceId, seances.dateSeance, seances.horaire, seances.prix, " +
                        "seances.capaciteMaximale, seances.salle, films.titre " +
                        "FROM seances INNER JOIN films ON seances.filmId = films.filmId";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("Seance ID: " + rs.getInt("seanceId"));
                System.out.println("Date: " + rs.getString("dateSeance"));
                System.out.println("Horaire: " + rs.getString("horaire"));
                System.out.println("Prix: " + rs.getFloat("prix"));
                System.out.println("Capacité: " + rs.getInt("capaciteMaximale"));
                System.out.println("Salle: " + rs.getString("salle"));
                System.out.println("Film Titre: " + rs.getString("titre"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void supprimerFilmfromdb(int id) {
        String supprimer_film = "DELETE FROM films WHERE filmId = ?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(supprimer_film)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();  // ✔ Execute delete

            if (rowsAffected > 0) {
                System.out.println("Film supprimé avec succès !");
            } else {
                System.out.println("Aucun film trouvé avec cet ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void supprimerSeanceFromDB(int seanceId) {
        String supprimerSeance = "DELETE FROM seances WHERE seanceId = ?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(supprimerSeance)) {

            ps.setInt(1, seanceId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Séance supprimée avec succès !");
            } else {
                System.out.println("Aucune séance trouvée avec cet ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

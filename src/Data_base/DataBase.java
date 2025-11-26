package Data_base;

import DBconnection.DBconnection;
import Film.Film;
import Seance.Seance;
import Spectateur.Spectateur;
import Ticket.Ticket;

import java.sql.*;

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
                System.out.printf(
                        "Film ID: %d | Titre: %s | Durée: %s | Catégorie: %s%n",
                        rs.getInt("filmId"),
                        rs.getString("titre"),
                        rs.getString("duree"),
                        rs.getString("categorie")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public float getSeancePrix(int seanceId) {
        String sql = "SELECT prix FROM seances WHERE seanceId = ?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, seanceId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getFloat("prix");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0; // return 0 if not found or error
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
                System.out.printf(
                        "Seance ID: %d | Date: %s | Horaire: %s | Prix: %.2f | Capacité: %d | Salle: %s | Film Titre: %s%n",
                        rs.getInt("seanceId"),
                        rs.getString("dateSeance"),
                        rs.getString("horaire"),
                        rs.getFloat("prix"),
                        rs.getInt("capaciteMaximale"),
                        rs.getString("salle"),
                        rs.getString("titre")
                );
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
    public void ajouterSpectateurToDatabase(Spectateur spectateur) {
        String ajouter_spectateur_sql = "INSERT INTO spectateurs(nom, email) VALUES (?, ?)";
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(ajouter_spectateur_sql);
            ps.setString(1, spectateur.getNom());
            ps.setString(2, spectateur.getEmail());
            ps.executeUpdate();
            System.out.println("spectateur ajouter avec  succe!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getSpectateurFromDB() {
        String getspectateurs = "SELECT * FROM spectateurs";
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(getspectateurs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.printf(
                        "Spectateur ID: %d | Nom: %s | Email: %s%n",
                        rs.getInt("spectateurId"),
                        rs.getString("nom"),
                        rs.getString("email")
                );
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getSpectateurId(String nom) {
        String sql = "SELECT spectateurId FROM spectateurs WHERE nom = ?";
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("spectateurId");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void ajouterTicket(Ticket ticket){
        String ajouter_ticket_sql = "INSERT INTO `tickets`(`prix`, `seanceId`, `spectateurId`) VALUES (?,?,?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(ajouter_ticket_sql)) {

            ps.setFloat(1, ticket.getPrix());
            ps.setInt(2, ticket.getSeanceId());
            ps.setInt(3,ticket.getSpectateurId());

            ps.executeUpdate();
            System.out.println("tickt est creer avec succes!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void afficherTicketsParSpectateur(int spectateurId) {
        String sql = "SELECT * FROM tickets WHERE spectateurId = ?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, spectateurId);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf(
                        "Ticket ID: %d | Prix: %.2f | Séance ID: %d | Spectateur ID: %d%n",
                        rs.getInt("ticketId"),
                        rs.getFloat("prix"),
                        rs.getInt("seanceId"),
                        rs.getInt("spectateurId")
                );
            }


            if (!found) {
                System.out.println("Aucun ticket trouvé pour le spectateur ID: " + spectateurId);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

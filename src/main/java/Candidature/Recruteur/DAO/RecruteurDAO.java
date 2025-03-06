package Candidature.Recruteur.DAO;

import Candidature.Recruteur.Model.RecruteurModel;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecruteurDAO {

    public void ajouterRecruteur(RecruteurModel recruteur) {
        String sqlUser = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, 'recruiter')";
        String sqlRecruteur = "INSERT INTO recruiters (id, company) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmtUser = conn.prepareStatement(sqlUser, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtRecruteur = conn.prepareStatement(sqlRecruteur)) {

            conn.setAutoCommit(false); // Transaction

            stmtUser.setString(1, recruteur.getName());
            stmtUser.setString(2, recruteur.getEmail());
            stmtUser.setString(3, recruteur.getPassword());
            stmtUser.executeUpdate();

            ResultSet rs = stmtUser.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                stmtRecruteur.setInt(1, generatedId);
                stmtRecruteur.setString(2, recruteur.getCompany());
                stmtRecruteur.executeUpdate();
                recruteur.setId(generatedId);
            }

            conn.commit(); // Valider la transaction
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RecruteurModel obtenirRecruteurParId(int id) {
        String sql = "SELECT u.id, u.name, u.email, u.password, r.company FROM users u JOIN recruiters r ON u.id = r.id WHERE u.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new RecruteurModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("company")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RecruteurModel> obtenirTousLesRecruteurs() {
        List<RecruteurModel> recruteurs = new ArrayList<>();
        String sql = "SELECT u.id, u.name, u.email, r.company FROM users u JOIN recruiters r ON u.id = r.id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                recruteurs.add(new RecruteurModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        "", // Ne pas récupérer le mot de passe
                        rs.getString("company")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruteurs;
    }

    public void mettreAJourRecruteur(RecruteurModel recruteur) {
        String sqlUser = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        String sqlRecruteur = "UPDATE recruiters SET company = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
             PreparedStatement stmtRecruteur = conn.prepareStatement(sqlRecruteur)) {
            conn.setAutoCommit(false);

            stmtUser.setString(1, recruteur.getName());
            stmtUser.setString(2, recruteur.getEmail());
            stmtUser.setString(3, recruteur.getPassword());
            stmtUser.setInt(4, recruteur.getId());
            stmtUser.executeUpdate();

            stmtRecruteur.setString(1, recruteur.getCompany());
            stmtRecruteur.setInt(2, recruteur.getId());
            stmtRecruteur.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerRecruteur(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

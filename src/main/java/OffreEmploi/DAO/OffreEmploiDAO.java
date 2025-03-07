package OffreEmploi.DAO;

import OffreEmploi.Model.OffreEmploi;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffreEmploiDAO {


        private static Connection connection;

        public OffreEmploiDAO() throws SQLException {
            this.connection= DBConnection.getConnection();
        }
        public static void createOffre(OffreEmploi offre) throws SQLException {
            String query = "INSERT INTO job_offers (title, description, recruiter_id) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setString(1, offre.getTitle());
                stmt.setString(2, offre.getDescription());
                stmt.setInt(3, offre.getRecruteur());
                stmt.executeUpdate() ;

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    public static OffreEmploi getOffreById(int id) throws SQLException {
        String query = "SELECT * FROM job_offers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int recruiterId = resultSet.getInt("recruiter_id");

                return new OffreEmploi(id, title, description, recruiterId);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while retrieving job offer", e);
        }
    }
    public List<OffreEmploi> getAllOffres() throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();
        String query = "SELECT * FROM job_offers";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            OffreEmploi offre = new OffreEmploi();
            while (resultSet.next()) {
                offre.setId(resultSet.getInt("id"));
                offre.setTitle(resultSet.getString("title"));
                offre.setDescription(resultSet.getString("description"));
               offre.setRecruteur(resultSet.getInt("recruiter_id"));

//                OffreEmploi offre = new OffreEmploi(id, title, description, recruiterId);
                offres.add(offre);
                System.out.println(offre.getTitle());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while retrieving job offers", e);
        }
        return offres;

    }

    public static void updateOffre(OffreEmploi offre) throws SQLException {
        String query = "UPDATE job_offers SET title = ?, description = ?, recruiter_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, offre.getTitle());
            stmt.setString(2, offre.getDescription());
            stmt.setInt(3, offre.getRecruteur());
            stmt.setInt(4, offre.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while updating job offer", e);
        }
    }


    public static void deleteOffre(int id) throws SQLException {
        String query = "DELETE FROM job_offers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while deleting job offer", e);
        }
    }

}




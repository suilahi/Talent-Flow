package Candidature.Recruteur.DAO;

import Candidature.Recruteur.Model.OfferStatusModel;
import Utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferStatusDAO {
    private Connection connection;

    public OfferStatusDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    // Récupérer les candidatures reçues pour une offre d’emploi spécifique
    public List<OfferStatusModel> getCandidaturesByJob(int jobId, String filter, String sort) {
        List<OfferStatusModel> candidatures = new ArrayList<>();
        String sql = "SELECT * FROM offer_status WHERE job_id = ?";

        // Ajout des filtres et du tri
        if (filter != null && !filter.isEmpty()) {
            sql += " AND status = '" + filter + "'";
        }
        if (sort != null && !sort.isEmpty()) {
            sql += " ORDER BY " + sort;
        } else {
            sql += " ORDER BY updated_at DESC";
        }

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, jobId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OfferStatusModel candidature = new OfferStatusModel(
                        rs.getInt("id"),
                        rs.getInt("job_id"),
                        rs.getInt("candidate_id"),
                        rs.getString("status"),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
                candidatures.add(candidature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatures;
    }

    // Modifier le statut d’une candidature
    public boolean updateStatus(int candidatureId, String newStatus) {
        String sql = "UPDATE offer_status SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, candidatureId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

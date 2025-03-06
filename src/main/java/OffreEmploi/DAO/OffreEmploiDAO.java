package OffreEmploi.DAO;

import OffreEmploi.Model.OffreEmploi;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OffreEmploiDAO {


        private Connection connection;

        public OffreEmploiDAO() throws SQLException {
            this.connection= DBConnection.getConnection();
        }
        public boolean createOffre(OffreEmploi offre) throws SQLException {
            String query = "INSERT INTO job_offers (title, description, recruiter_id) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, offre.getTitle());
                stmt.setString(2, offre.getDescription());
                stmt.setInt(3, offre.getRecruiter());
                return stmt.executeUpdate() > 0;
            }

        }
}



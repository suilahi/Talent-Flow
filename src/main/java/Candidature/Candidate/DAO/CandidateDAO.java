
package Candidature.Candidate.DAO;

import Candidature.Candidate.*;
import Utils.DBConnection;
import authentification.Model.Candidat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    private Connection connection;

    public CandidateDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public void addCandidate(Candidat candidate) throws SQLException {
        String query = "INSERT INTO candidates (name, email, password, role, cv) VALUES (?, ?, ?, ?, ?)";


        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getEmail());
            statement.setString(3, candidate.getPassword());
            statement.setString(4, candidate.getRole());
            statement.setString(5, candidate.getCv());

        }
    }
    // postuler a une offre d'emploi
    public void postuler (Candidat candidat) throws SQLException {

        String query = "INSERT INTO candidates (phone, cv) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, candidat.getPhone());
            stmt.setString(2, candidat.getCv());
            stmt.executeUpdate();
        }
    }

    public void postuler(Integer candidateId, int jobId) {

    }
}

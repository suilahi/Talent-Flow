package Candidature.Candidate.DAO;

import Candidature.Candidate.Model.CandidateModel;
import Utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    private Connection connection;

    public CandidateDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }


    // postuler a une offre d'emploi
    public void Postuler(CandidateModel candidate) {

        String sql = "INSERT INTO candidates (phone, cv) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, candidate.getPhone());
            stmt.setString(2, candidate.getCv());

            stmt.executeUpdate();
            System.out.println("Candidature ajoutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
//    // Récupérer un candidat par ID
//    public CandidateModel getCandidateById(int id) {
//        String sql = "SELECT * FROM candidates WHERE id = ?";
//        CandidateModel candidate = null;
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                candidate = new CandidateModel(
//                        rs.getString("name"),
//                        rs.getString("email"),
//                        rs.getString("password"),
//                        rs.getString("role")
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return candidate;
//    }

//    // Récupérer tous les candidats
//    public List<CandidateModel> getAllCandidates() {
//        List<CandidateModel> candidates = new ArrayList<>();
//        String sql = "SELECT * FROM candidates";
//
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                candidates.add(new CandidateModel(
//                        rs.getString("name"),
//                        rs.getString("email"),
//                        rs.getString("password"),
//                        rs.getString("role"))
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return candidates;
//    }

//    // Mettre à jour un candidat
//    public void updateCandidate(CandidateModel candidate) {
//        String sql = "UPDATE candidates SET name = ?, email = ?, password = ?, role = ?, cv = ? WHERE id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, candidate.getName());
//            stmt.setString(2, candidate.getEmail());
//            stmt.setString(3, candidate.getPassword());
//            stmt.setString(4, candidate.getRole().toString());
//            stmt.setString(5, candidate.getCv());
//            stmt.setInt(6, candidate.getId());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }




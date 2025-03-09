
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



=======
//package Candidature.Candidate.DAO;
//
//import Utils.DBConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class CandidateDAO {
//
//    private Connection connection;
//
//    public CandidateDAO() throws  SQLException {
//        this.connection = DBConnection.getConnection();
//    }
//
//    //POSTULER A UNE CANDIDATURE
//
//    public void Postuler(int job_id,int candidate_id) {
//        String sql = "insert into offer_status (job_id , candidate_id) values (?,?)";
//
//        try (PreparedStatement stmt =connection.prepareStatement(sql)) {
//            stmt.setInt(1, job_id);
//            stmt.setInt(2, candidate_id);
//            stmt.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//
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
//
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
//
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

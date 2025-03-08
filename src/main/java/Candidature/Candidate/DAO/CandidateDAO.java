package Candidature.Candidate.DAO;

import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidateDAO {

    private Connection connection;

    public CandidateDAO() throws  SQLException {
        this.connection = DBConnection.getConnection();
    }

    //POSTULER A UNE CANDIDATURE

    public void Postuler(int job_id,int candidate_id) {
        String sql = "insert into offer_status (job_id , candidate_id) values (?,?)";

        try (PreparedStatement stmt =connection.prepareStatement(sql)) {
            stmt.setInt(1, job_id);
            stmt.setInt(2, candidate_id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}



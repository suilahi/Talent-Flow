package Candidature.Recruteur.Model;

import java.time.LocalDateTime;

public class OfferStatusModel {
    private int id;
    private int jobId;
    private int candidateId;
    private String status;
    private LocalDateTime updatedAt;

    public OfferStatusModel(int id, int jobId, int candidateId, String status, LocalDateTime updatedAt) {
        this.id = id;
        this.jobId = jobId;
        this.candidateId = candidateId;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

package OffreEmploi.Model;
import authentification.Model.Recruteur;
import java.time.LocalDateTime;

public class OffreEmploi {

        private int id;
        private String title;
        private String description;
        public Recruteur recruteur;
        private LocalDateTime createdAt;

        public OffreEmploi(String title, String description, Recruteur recruteur ) {
            this.title = title;
            this.description = description;
            this.recruteur =recruteur ;
            this.createdAt = LocalDateTime.now();
        }

        // Getters and Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public int getRecruiter() { return recruteur.getId(); }
        public void setRecruiter(Recruteur recruiter) { this.recruteur = recruteur; }
        public LocalDateTime getCreatedAt() { return createdAt; }

    }


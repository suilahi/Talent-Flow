package OffreEmploi.Model;
import authentification.Model.Recruteur;
import java.time.LocalDateTime;

public class OffreEmploi {

        private int id;
        private String title;
        private String description;
        private int  recruteur;
        private LocalDateTime createdAt;

        public OffreEmploi(String title, String description, int recruteur ) {
            this.title = title;
            this.description = description;
            this.recruteur =recruteur ;
            this.createdAt = LocalDateTime.now();
        }


    public OffreEmploi() {

    }

    public OffreEmploi(int id, String title, String description, int recruteur) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.recruteur = recruteur;
    }

    // Getters and Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

    public int getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(int recruteur) {
        this.recruteur = recruteur;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "OffreEmploi " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recruteur=" + recruteur +
                ", createdAt=" + createdAt ;
    }
}


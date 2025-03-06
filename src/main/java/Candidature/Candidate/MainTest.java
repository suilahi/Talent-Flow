package Candidature.Candidate;

import Candidature.Candidate.DAO.CandidateDAO;
import Candidature.Candidate.Model.CandidateModel;
import authentification.Model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CandidateDAO candidateDAO = new CandidateDAO();


        while (true) {
            System.out.println("\n===== Gestion des Candidats =====");
            System.out.println("1. Ajouter un candidat");
            System.out.println("2. Voir tous les candidats");
            System.out.println("3. Chercher un candidat par ID");
            System.out.println("4. Mettre à jour un candidat");
            System.out.println("5. Supprimer un candidat");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String name = scanner.nextLine();

                    System.out.print("Email : ");
                    String email = scanner.nextLine();

                    System.out.print("Mot de passe : ");
                    String password = scanner.nextLine();

                    System.out.print("Role (CANDIDATE/RECRUITER) : ");
                    String roleStr = scanner.nextLine().toUpperCase();

                    System.out.print("CV (lien ou texte) : ");
                    String cv = scanner.nextLine();

                    User.UserRole role = User.UserRole.valueOf(roleStr);
                    CandidateModel candidate = new CandidateModel("John Doe", "john@example.com", "1234", User.UserRole.CANDIDATE, "cv.pdf");

                    candidateDAO.addCandidate(candidate);
                    System.out.println("✅ Candidat ajouté !");
                    break;

                case 2:
                    List<CandidateModel> candidates = candidateDAO.getAllCandidates();
                    System.out.println("\n--- Liste des Candidats ---");
                    for (CandidateModel c : candidates) {
                        System.out.println("ID: " + c.getId() + ", Nom: " + c.getName() +
                                ", Email: " + c.getEmail() + ", CV: " + c.getCv());
                    }
                    break;

                case 3:
                    System.out.print("ID du candidat : ");
                    int id = scanner.nextInt();
                    CandidateModel foundCandidate = candidateDAO.getCandidateById(id);
                    if (foundCandidate != null) {
                        System.out.println("✅ Candidat trouvé : " + foundCandidate.getName() + ", CV: " + foundCandidate.getCv());
                    } else {
                        System.out.println("⚠️ Aucun candidat trouvé avec cet ID !");
                    }
                    break;

                case 4:
                    System.out.print("ID du candidat à modifier : ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consommer la ligne

                    System.out.print("Nouveau Nom : ");
                    String newName = scanner.nextLine();

                    System.out.print("Nouveau Email : ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Nouveau Mot de passe : ");
                    String newPassword = scanner.nextLine();

                    System.out.print("Nouveau Role (CANDIDATE/RECRUITER) : ");
                    String newRoleStr = scanner.nextLine().toUpperCase();

                    System.out.print("Nouveau CV : ");
                    String newCv = scanner.nextLine();

                    User.UserRole newRole = User.UserRole.valueOf(newRoleStr);
                    CandidateModel updatedCandidate = new CandidateModel(updateId, newName, newEmail, newPassword, newRole, newCv);
                    candidateDAO.updateCandidate(updatedCandidate);
                    System.out.println("✅ Candidat mis à jour !");
                    break;


                case 6:
                    System.out.println("🚀 Fin du programme !");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Choix invalide, réessayez.");
            }
        }
    }
}


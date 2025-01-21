/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gesnotestudent;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TDI
 */
public class GesNoteStudent {


    public static void main(String[] args){
        GestionNotes gestionNotes = new GestionNotes();
        Scanner scanner = new Scanner(System.in);

         while (true) {
            System.out.println("1. Ajouter un etudiant");
            System.out.println("2. Ajouter une matiere");
            System.out.println("3. Ajouter une note");
            System.out.println("4. Afficher les notes des etudiants par matiere");
            System.out.println("5. Afficher les etudiants ayant une note precise sur une matiere");
            System.out.println("6. Afficher toutes les notes");
            System.out.println("7. Liste de tous les etudiants");
            System.out.println("8. Liste de toutes les matieres");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option: ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prenom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Specialité: "); // Demander la spécialité
                    String specialite = scanner.nextLine();
                    gestionNotes.ajouterEtudiant(new Etudiant(nom, prenom, specialite));
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;

                case "2":
                    System.out.print("Nom de la matière: ");
                    String nomMatiere = scanner.nextLine();
                    gestionNotes.ajouterMatiere(nomMatiere);
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;


                case "3":
                    System.out.print("Nom de l'etudiant: ");
                    String nomEtudiant = scanner.nextLine();
                    System.out.print("Matiere: ");
                    String matiere = scanner.nextLine();
                    System.out.print("Note: ");
                    double note = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    gestionNotes.ajouterNote(nomEtudiant, matiere, note);
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;

                case "4":
                    /*System.out.print("Nom de l'etudiant: ");
                    String nomAffichage = scanner.nextLine();*/
                    System.out.print("Matiere: ");
                    String matiereAffichage = scanner.nextLine();
                    gestionNotes.afficherNotesParMatiere(matiereAffichage);
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;

                case "5":
                    System.out.print("Matiere: ");
                    String matiereFiltre = scanner.nextLine();
                    System.out.print("Note (seuil): ");
                    double noteFiltre = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Filtrer (1: supérieur ou égal, 2: inférieur): ");
                    int optionFiltre = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    boolean estSuperieur = (optionFiltre == 1);
                    gestionNotes.afficherEtudiantsAvecNote(matiereFiltre, noteFiltre, estSuperieur);
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;

                case "6":
                    gestionNotes.afficherNotes(); // Affiche toutes les notes
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;

                case "7":
                    gestionNotes.afficherEtudiants(); // Affiche tous les étudiants
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;
                    
                case "8":
                    gestionNotes.afficherMatieres(); // Affiche tous les étudiants
                    System.out.println("Appuyez sur une touche pour continuer ");
                    scanner.nextLine();
                    break;
                    
                case "9":
                    scanner.close();
                    return;

                   
                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}


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
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Ajouter une matière");
            System.out.println("3. Ajouter une note");
            System.out.println("4. Afficher les notes d'un étudiant par matière");
            System.out.println("5. Afficher les étudiants ayant une note précise sur une matière");
            System.out.println("6. Afficher toutes les notes");
            System.out.println("7. Liste de tous les etudiants");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option: ");
            String choix = scanner.nextLine();


            switch (choix) {
                case "1":
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    gestionNotes.ajouterEtudiant(new Etudiant(nom, prenom));
                    break;

                case "2":
                    System.out.print("Nom de la matière: ");
                    String nomMatiere = scanner.nextLine();
                    System.out.print("Spécialité: ");
                    String specialite = scanner.nextLine();
                    gestionNotes.ajouterMatiere(nomMatiere, specialite);
                    break;

                case "3":
                    System.out.print("Nom de l'étudiant: ");
                    String nomEtudiant = scanner.nextLine();
                    System.out.print("Matière: ");
                    String matiere = scanner.nextLine();
                    System.out.print("Note: ");
                    double note = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    gestionNotes.ajouterNote(nomEtudiant, matiere, note);
                    break;

                case "4":
                    System.out.print("Nom de l'étudiant: ");
                    String nomAffichage = scanner.nextLine();
                    System.out.print("Matière: ");
                    String matiereAffichage = scanner.nextLine();
                    gestionNotes.afficherNotesParMatiere(nomAffichage, matiereAffichage);
                    break;

                case "5":
                    System.out.print("Matière: ");
                    String matiereFiltre = scanner.nextLine();
                    System.out.print("Note (seuil): ");
                    double noteFiltre = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Filtrer (1: supérieur ou égal, 2: inférieur): ");
                    int optionFiltre = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    boolean estSuperieur = (optionFiltre == 1);
                    gestionNotes.afficherEtudiantsAvecNote(matiereFiltre, noteFiltre, estSuperieur);
                    break;


                case "6":
                    gestionNotes.afficherNotes(); // Affiche toutes les notes
                    break;
                    
                 case "7":
                    gestionNotes.afficherEtudiants(); // Affiche toutes les notes
                    break;

                case "8":
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gesnotestudent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TDI
 */
public class GestionNotes {
    private final String fichierEtudiants = "etudiants.txt";
    private final String fichierNotes = "notes.txt";
    private final String fichierMatieres = "matieres.txt";
    private Map<String, Matiere> matieres = new HashMap<>();

    public GestionNotes() {
        chargerMatieres();
    }

    private void chargerMatieres() {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierMatieres))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String nomMatiere = ligne.trim();
                if (!nomMatiere.isEmpty()) {
                    matieres.put(nomMatiere, new Matiere(nomMatiere));
                }
            }
            System.out.println("Matières chargées depuis " + fichierMatieres);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des matières : " + e.getMessage());
        }
    }
    
    private boolean etudiantExiste(String nomEtudiant) {
    try (BufferedReader br = new BufferedReader(new FileReader(fichierEtudiants))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split("\\s+");
            if (parts.length >= 1 && parts[0].equalsIgnoreCase(nomEtudiant)) {
                return true; // L'étudiant existe
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // L'étudiant n'existe pas
}

    public void ajouterEtudiant(Etudiant etudiant) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierEtudiants, true))) {
            bw.write(String.format("%-20s %-20s %-20s", etudiant.getNom(), etudiant.getPrenom(), etudiant.getSpecialite()));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterMatiere(String nom) {
        if (matieres.containsKey(nom)) {
            System.out.println("La matière " + nom + " existe déjà !");
            return;
        }

        matieres.put(nom, new Matiere(nom));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("matieres.txt", true))) {
            bw.write(nom);
            bw.newLine();
            System.out.println("Matière " + nom + " ajoutée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterNote(String nomEtudiant, String nomMatiere, double note) {
        if (!matieres.containsKey(nomMatiere)) {
            System.out.println("La matiere " + nomMatiere + " n'existe pas !");
            return;
        }

        if (!etudiantExiste(nomEtudiant)) {
            System.out.println("L'étudiant " + nomEtudiant + " n'existe pas !");
            return;
        }

        if (noteDejaAjoute(nomEtudiant, nomMatiere)) {
            System.out.println("L'etudiant " + nomEtudiant + " a deja une note pour la matiere " + nomMatiere + " !");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierNotes, true))) {
            bw.write(String.format("%-20s %-20s %.2f", nomEtudiant, nomMatiere, note));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean noteDejaAjoute(String nomEtudiant, String nomMatiere) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierNotes))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split("\\s+");
                if (parts.length >= 3 && parts[0].equals(nomEtudiant) && parts[1].equals(nomMatiere)) {
                    return true; // La note existe déjà
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Aucune note trouvée
    }

    public void afficherNotes() {
        System.out.printf("%-20s %-20s %-10s%n", "Nom Étudiant", "Matière", "Note");
        System.out.println("---------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(fichierNotes))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void afficherEtudiants() {
        System.out.printf("%-20s %-20s %-20s%n", "Nom Étudiant", "Prénom Étudiant", "Spécialité");
        System.out.println("---------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(fichierEtudiants))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void afficherMatieres() {
        System.out.printf("%-20s%n", "Matiere");
        System.out.println("---------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(fichierMatieres))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherNotesParMatiere(String matiere) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierNotes))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split("\\s+");
                if (parts.length >= 3 && parts[1].equals(matiere)) {
                    System.out.println(ligne);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherEtudiantsAvecNote(String matiere, double seuil, boolean estSuperieur) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierNotes))) {
            String ligne;
            System.out.printf("%-20s %-20s %-10s%n", "Nom Étudiant", "Matière", "Note");
            System.out.println("---------------------------------------------");
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split("\\s+");
                if (parts.length >= 3 && parts[1].equals(matiere)) {
                    double note = Double.parseDouble(parts[2].replace(",", "."));
                    if ((estSuperieur && note >= seuil) || (!estSuperieur && note <= seuil)) {
                        System.out.println(ligne);
                    }
                }
            }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}



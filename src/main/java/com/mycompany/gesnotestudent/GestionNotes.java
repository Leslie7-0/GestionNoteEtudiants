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
    private Map<String, Matiere> matieres = new HashMap<>();

    public void ajouterEtudiant(Etudiant etudiant) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierEtudiants, true))) {
            bw.write(String.format("%-20s %-20s", etudiant.getNom(), etudiant.getPrenom()));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterNote(String nomEtudiant, String matiere, double note) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierNotes, true))) {
        bw.write(String.format("%-20s %-20s %.2f", nomEtudiant, matiere, note));
        bw.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }

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
        System.out.printf("%-20s %-20s%n", "Nom Étudiant", "Prenom Étudiant");
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
    
    public void ajouterMatiere(String nom, String specialite) {
        matieres.put(nom, new Matiere(nom, specialite));
    }

    public void afficherNotesParMatiere(String nomEtudiant, String matiere) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierNotes))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split("\\s+");
                if (parts.length >= 3 && parts[0].equals(nomEtudiant) && parts[1].equals(matiere)) {
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
                double note = Double.parseDouble(parts[2].replace(",", ".")); // Remplacer la virgule par un point pour le parsing
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



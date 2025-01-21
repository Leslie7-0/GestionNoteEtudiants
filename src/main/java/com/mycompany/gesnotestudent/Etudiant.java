/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gesnotestudent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author TDI
 */
public class Etudiant {
    private String nom;
    private String prenom;
    private String specialite;

    public Etudiant(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
     public String getSpecialite() {
        return specialite;
    }

    
}

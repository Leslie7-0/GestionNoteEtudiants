/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gesnotestudent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author TDI
 */
public class Matiere {
    private String nom;
    private String specialite;

    public Matiere(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epfc.cours3449L17Bis;

public class Personne {
    String nom;
    Adresse adresse;
    String numeroNation;

    public Personne(String nom, Adresse adresse, String numeroNation) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroNation = numeroNation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setNumeroNation(String numeroNation) {
        this.numeroNation = numeroNation;
    }

    public String getNom() {
        return nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getNumeroNation() {
        return numeroNation;
    }
}
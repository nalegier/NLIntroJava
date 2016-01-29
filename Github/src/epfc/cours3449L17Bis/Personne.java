/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epfc.cours3449L17Bis;

import java.util.ArrayList;

public class Personne {
    String nom;
    private final ArrayList<Adresse> adresses;
    String numeroNation;

    public Personne(String nom) {
        this.nom = nom;
        //creation of a person with a null adresse
        adresses = new ArrayList<Adresse>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void addAdresse(Adresse ad1) {
        adresses.add(ad1);
    }

    public void setNumeroNation(String numeroNation) {
        this.numeroNation = numeroNation;
    }

    public String getNom() {
        return nom;
    }

    public Adresse getAdresse(int index) {
        return adresses.get(index);
    }
    
    public int getSize(){
        return adresses.size();
    }
    public String getNumeroNation() {
        return numeroNation;
    }
}
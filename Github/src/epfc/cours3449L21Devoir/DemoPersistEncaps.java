package epfc.cours3449L21Devoir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoPersistEncaps {

    static Catalogue cat;
    static final String nomDeFichier = "livre.csv";

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        cat = new Catalogue(nomDeFichier);
        lireLeCatalogue();
        ajout2Livres();
        ///creeDeuxLivres();
        ///testDeleteNoLivre();        
        ///lireLeCatalogue();
        ///TestReadByAuteur();
    }
/*
    private static void TestReadByAuteur() {
        System.out.println("\n\n---------------------------------------------------------------");
        ArrayList<Livre> livresDeVictor = cat.readByAuteur("Victor");
        for (Livre livre : livresDeVictor) {
            System.out.println(livre.toString());
        }
    }
*/
    private static void lireLeCatalogue() throws FileNotFoundException {
        cat.readFile();
        }
    
    private static void ajout2Livres() throws FileNotFoundException {
        Livre l1 = new Livre("Notre Dame","Victor");
        Livre l2 = new Livre("Dôme","Stephen King");
        try {
            cat.ajoutLigne(l1);
            cat.ajoutLigne(l2);
        } catch (IOException ex) {
            Logger.getLogger(DemoPersistEncaps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    private static void testDeleteNoLivre() {
        try {
            Livre l = new Livre("test", "auteur");
            cat.delete(l.getId());
        } catch (Exception ex) {
            System.out.println( ex);
        }
    }


    

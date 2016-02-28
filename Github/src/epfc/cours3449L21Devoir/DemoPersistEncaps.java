package epfc.cours3449L21Devoir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoPersistEncaps {

    static Catalogue cat;
    static final String nomDeFichier = "livre.csv";
    static Scanner keyb = new Scanner(System.in);
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        cat = new Catalogue(nomDeFichier);
        lireLeCatalogue();
        //ajoutDeuxLivres();
        delete1Livre();
        updateLivre();
    }

    private static void lireLeCatalogue() throws FileNotFoundException {
        cat.readFile();
        }
    
    private static void ajoutDeuxLivres() throws FileNotFoundException {
        Livre l1 = new Livre("Notre Dame","Victor");
        Livre l2 = new Livre("Dôme","Stephen King");
        try {
            cat.ajoutLigne(l1);
            cat.ajoutLigne(l2);
        } catch (IOException ex) {
            Logger.getLogger(DemoPersistEncaps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void delete1Livre() throws FileNotFoundException, IOException { 
        System.out.println("Please give the identifiant of the book to delete");
        String identifiant = keyb.nextLine(); 
        cat.deleteUnLivre(identifiant);
    }

    private static void updateLivre() {
        System.out.println("Please give the identifiant of the book to update: ");
        String identifiant = keyb.nextLine();
        
    }

}


    

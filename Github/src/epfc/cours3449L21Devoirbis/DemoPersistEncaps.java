package epfc.cours3449L21Devoirbis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoPersistEncaps {

    static Catalogue cat;
    static final String nomDeFichier = "livre.txt";
     static Scanner keyb = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        cat = new Catalogue(nomDeFichier);
        lireLeCatalogue();
        creeDeuxLivres();
        lireLeCatalogue();
        //testDeleteNoLivre();        
       
        ///TestReadByAuteur();
    }

    /*private static void TestReadByAuteur() {
        System.out.println("\n\n---------------------------------------------------------------");
        ArrayList<Livre> livresDeVictor = cat.readByAuteur("Victor");
        for (Livre livre : livresDeVictor) {
            System.out.println(livre.toString());
        }
    }
*/
    private static void lireLeCatalogue() throws IOException {
        ArrayList<Livre> sendCat = cat.read();
        for (Livre livre : sendCat) {
            System.out.println(livre.toString());
        }
    }

    /*private static void testDeleteNoLivre() {
        try {
            Livre l = new Livre("test", "auteur");
            cat.delete(l.getId());
        } catch (Exception ex) {
            System.out.println( ex);
        }
    }
    */
    
    private static void creeDeuxLivres() throws FileNotFoundException, IOException {
        Livre l1 = new Livre("Notre Dame", "Victor");
        cat.add(l1);
        Livre l2 = new Livre("Java ...", "Orstmann");
        cat.add(l2);
    }
    
    
        private static void delete1Livre() throws FileNotFoundException, IOException, Exception { 
        System.out.println("Please give the identifiant of the book to delete");
        int identifiant = keyb.nextInt(); 
        cat.delete(identifiant);
    }

    private static void updateLivre() throws IOException {
        System.out.println("Please give the identifiant of the book to update: ");
        int identifiant = keyb.nextInt();
        System.out.println("New Title: ");
        String newtitre = keyb.nextLine();
        System.out.println("New Autor: ");
        String newauteur = keyb.nextLine();
        cat.add(new Livre(identifiant, newtitre, newauteur));
                
    }
}

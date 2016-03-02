package epfc.cours3449L21Devoirbis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DemoPersistEncaps {

    static Catalogue cat;
    static final String nomDeFichier = "livre.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        cat = new Catalogue(nomDeFichier);
        lireLeCatalogue();
        //creeDeuxLivres();
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

    private static void testDeleteNoLivre() {
        try {
            Livre l = new Livre("test", "auteur");
            cat.delete(l.getId());
        } catch (Exception ex) {
            System.out.println( ex);
        }
    }

    private static void creeDeuxLivres() throws FileNotFoundException, IOException {
        Livre l1 = new Livre("Notre Dame", "Victor");
        cat.add(l1);
        Livre l2 = new Livre("Java ...", "Orstmann");
        cat.add(l2);
    }
}

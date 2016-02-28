package epfc.cours3449L21Devoir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Catalogue {

    private String nomDeFichier;

    public Catalogue(String nomDeFichier) throws FileNotFoundException, IOException {
        this.nomDeFichier = nomDeFichier;
        openFile();
    }

  
    private void openFile() throws FileNotFoundException {
        File file = new File(nomDeFichier);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void readFile () throws FileNotFoundException{
        File file = new File(nomDeFichier);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            ///System.out.println(elements[0] + " " + elements[1] + " " + elements[2]);
            //String id = elements[0];
            int id = Integer.parseInt(elements[0]);
            //System.out.println(id);
            Livre l = new Livre( id, elements[1], elements[2]);
            System.out.println(l.toString());
        }
    }    
 
    
    }


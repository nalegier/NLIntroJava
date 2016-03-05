package epfc.cours3449L21Devoirbis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalogue {

//éliminer la cache:    private ArrayList<Livre> ls = new ArrayList<>();
    private String nomDeFichier;

    public Catalogue(String nomDeFichier) throws FileNotFoundException, IOException {
        this.nomDeFichier = nomDeFichier;
     //ne pas charger à la création        charge();
    }

    public void add(Livre l) throws IOException {
        //first we need to charge the file in an array
        ArrayList<Livre> ls = charge();
        Livre copy = new Livre(l.getTitre(), l.getAuteur());
        ls.add(copy);
        //then we need to save the new book in the file
        sauve(ls);
    }

    public void update(int id, Livre l) throws Exception {
        //first we need to charge the file in an array
        ArrayList<Livre> ls = charge();
        //then we search in the array Livre for the book corresponding to the ID provided in input parameter
        for (Livre livre : ls) {
            if (livre.getId() == id ){                  
                //if we find the book then we update the title and the autor and we save to the file
                livre.setTitre(l.getTitre());
                livre.setAuteur(l.getAuteur());
                sauve(ls);
                return;
            }
        }
        throw new Exception("The book is not found");
    }

    public void delete(int id) throws Exception {
        //first we need to charge the file in an array
        ArrayList<Livre> ls = charge();
        for (Livre livre : ls) {
            /*then we search in the array Livre for the book to be deleted based on the ID 
            provided in input parameter
            */
            if (livre.getId() == id) {
                ls.remove(livre);
                sauve(ls);
                return;
            }
        }
        throw new Exception("The book is not found");
    }

    Livre read(int id) throws Exception {
        //first we charge the file in an array
        ArrayList<Livre> ls = charge();
        for (Livre livre : ls) {
            if (livre.getId() == id) {
                return livre;
            }
        }
        throw new Exception("The book is not found");
    }

    ArrayList<Livre> read() throws IOException {
        //first we charge the file in an array
        ArrayList<Livre> ls = charge();
        return ls;
    }

    ArrayList<Livre> readByAuteur(String auteur) throws IOException {
        ArrayList<Livre> lsDeAuteur = new ArrayList<>();
        ArrayList<Livre> ls = charge();
        for (Livre livre : ls) {
            if (livre.getAuteur().equals(auteur)) {
                lsDeAuteur.add(livre);
            }
        }
        return lsDeAuteur;
    }

    private ArrayList<Livre> charge() throws FileNotFoundException, IOException {
        ArrayList<Livre> ls = new ArrayList<>();
        File file = new File(nomDeFichier);
        if (!file.exists()) {
            //file.createNewFile();
            System.out.println("The file " + nomDeFichier + " does not exist");
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            int id = Integer.parseInt(elements[0]);
            Livre l = new Livre( id, elements[1], elements[2]);
            ls.add(l);
        }
        return ls;
    }

    private void sauve(ArrayList<Livre> ls) {
        PrintWriter pw = null;
        try {
            File f = new File(nomDeFichier);
            pw = new PrintWriter(f);
            for (Livre l : ls) {
                pw.println(l.toCsv());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Exception " + ex);
        } finally {
            pw.close();
        }
    }
}

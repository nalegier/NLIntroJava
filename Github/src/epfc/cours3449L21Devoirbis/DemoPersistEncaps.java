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
        menu();
        
    }

    private static void menu() throws IOException, Exception {
        boolean next = true;
        while(next){
        System.out.println("If you want to add a book, enter A");
        System.out.println("If you want to delete a book, enter D");
        System.out.println("If you want to find a book, enter F");
        System.out.println("If you want to update a book, enter U");
        System.out.println("If you want to list the catalogue, enter R");
        System.out.println("To stop, press E");
        String choix = keyb.nextLine();
            choix = choix.toUpperCase();
            if (choix.length() == 0){
                choix = keyb.nextLine();
            }
            switch(choix){
                case "A":
                    add1Livre();
                    break;
                case "D":
                    delete1Livre();
                    break;
                case "F":
                    find1Livre();
                    break;     
                case "U":
                    update1Livre();
                    break;
                case "R":
                    lireLeCatalogue();
                    break;
                case "E":
                    next = false;
                    break;
                default:
                    System.out.println("Incorrect choice");
                   }
        }
    }
    
    private static void lireLeCatalogue() throws IOException {
        ArrayList<Livre> sendCat = cat.read();
        for (Livre livre : sendCat) {
            System.out.println(livre.toString());
        }
    }
    
    private static void add1Livre() throws FileNotFoundException, IOException {
        System.out.println("Enter a title: ");
        String title = keyb.nextLine();
        System.out.println("Enter an autor: ");
        String autor = keyb.nextLine();
        Livre l1 = new Livre(title, autor);
        cat.add(l1);
    }
    
    private static void delete1Livre() throws FileNotFoundException, IOException, Exception { 
        System.out.println("Please give the identifiant of the book to delete");
        int identifiant = keyb.nextInt(); 
        cat.delete(identifiant);
    }

    private static void updateLivre() throws IOException, Exception {
        System.out.println("Please give the identifiant of the book to update: ");
        int identifiant = Integer.parseInt(keyb.nextLine());
        System.out.println("New Title: ");
        String newtitre = keyb.nextLine();
        System.out.println("New Autor: ");                
        String newauteur = keyb.nextLine();
        cat.update(identifiant, new Livre(identifiant, newtitre, newauteur));
        
                
    }
    
    private static void find1Livre() throws IOException {
        System.out.println("Please enter the Autor you want to search");
        String autor = keyb.nextLine();
        ArrayList<Livre> livresDeVictor = cat.readByAuteur(autor);
        for (Livre livre : livresDeVictor) {
            System.out.println(livre.toString());
        }
    }
}

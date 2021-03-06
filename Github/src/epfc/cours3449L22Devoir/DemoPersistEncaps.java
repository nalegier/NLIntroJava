package epfc.cours3449L22Devoir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoPersistEncaps {

    static Catalogue cat;
    //static final String nomDeFichier = "livre.txt";
    static Scanner keyb = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        cat = new Catalogue();
        menu();
        
    }

    private static void menu() throws Exception {
        boolean next = true;
        while(next){
        System.out.println("\n       Menu ");
        System.out.println("--------------------------------------");
        System.out.println("If you want to add a book, enter A");
        System.out.println("If you want to delete a book, enter D");
        System.out.println("If you want to find a book, enter F");
        System.out.println("If you want to update a book, enter U");
        System.out.println("If you want to list the catalogue, enter R");
        System.out.println("To stop, press E");
        System.out.println("\n --------------------------------------");
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
                    updateLivre();
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
        System.out.println("List of Books in the catalogue \n");
        for (Livre livre : sendCat) {
            System.out.printf("Book: %-4d  Title: %-50s  Author: %-30s \n", livre.getId(), livre.getTitre(), livre.getAuteur());
            
        }
    }
   
    
    private static void add1Livre()  {
        System.out.println("Enter a title: ");
        String title = keyb.nextLine();
        System.out.println("Enter an autor: ");
        String autor = keyb.nextLine();
        Livre l1 = new Livre(title, autor);
        cat.add(l1);
    }
    
    private static void delete1Livre()  { 
        System.out.println("Please give the identifiant of the book to delete");
        int identifiant = keyb.nextInt(); 
        cat.delete(identifiant);
    }

    private static void updateLivre()  {
        System.out.println("Please give the identifiant of the book to update: ");
        int identifiant = Integer.parseInt(keyb.nextLine());
        System.out.println("New Title: ");
        String newtitre = keyb.nextLine();
        System.out.println("New Autor: ");                
        String newauteur = keyb.nextLine();
        cat.update(identifiant, new Livre(identifiant, newtitre, newauteur));
        
                
    }
    
    private static void find1Livre() {
        System.out.println("Please enter the Autor you want to search");
        String autor = keyb.nextLine().toUpperCase();
        ArrayList<Livre> livresDeVictor = cat.readByAuteur(autor);
        if (cat.readByAuteur(autor) == null){
            System.out.println("No Book found for this author");
        }
        System.out.println("List of Book from " + autor);
        for (Livre livre : livresDeVictor) {
           System.out.printf("Book: %-4d  Title: %-40s  Author: %-30s \n", livre.getId(), livre.getTitre(), livre.getAuteur());
        }
    }
}

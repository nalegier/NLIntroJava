/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epfc.cours3449Bibliotheque;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 0101nalegier
 */
public class GestionLivres {
        static Catalogue cat;
        static Scanner keyb = new Scanner(System.in);
       
    public static void main(String[] args) throws BusinessException {
           printWelcome();
           affichemenu();
        
       }

    
    public static void printWelcome() throws BusinessException{
        System.out.println("Welcome to the Library application");
        cat = new Catalogue();
     }
    
    public static void affichemenu(){
        boolean next = true;
        
        while(next ){
            //method pour afficher un menu
            System.out.println("Select an option: ");
            System.out.println("F to find a book");
            System.out.println("C to create a book");
            System.out.println("U to update a book");
            System.out.println("D to remove a book");
            System.out.println("Q to quit the menu");
            String choix = keyb.nextLine();
            choix = choix.toUpperCase();
            switch(choix){
                case "F":
                    find();
                    break;
                case "C":
                    createLivre();
                    break;
                case "U":
                    updateLivre();
                    break;
                case "D":
                    break;
                case "Q":
                    next = false;
                    break;
               
            }
        }
    }
       
    public static void find(){
        //method pour lire un record specific
        System.out.println("Enter the identifiant number ");
        String iden = keyb.next();
        System.out.println(cat.findIdentifiant(iden).toString());
        ////System.out.println(cat.);
        
    }

    public static void createLivre() {
        try {
        System.out.println("Catalogue information");
        System.out.println("Enter the identifiant: ");
         String identifiant = keyb.nextLine();
         System.out.println("Enter the place :");
         String place = keyb.nextLine();
         System.out.println("Enter the purchase date: ");
         String dateachat = keyb.nextLine();
         cat.addLivres(new Livre(identifiant,place, dateachat));
        }
        catch (BusinessException ex) {
            Logger.getLogger(GestionLivres.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static void updateLivre() throws BusinessException{
        System.out.print("Please give the identifiar of the book to update: ");
        String identifiant = keyb.nextLine();
        System.out.println("New identifiant ");
        String newidentifiant = keyb.nextLine();
        System.out.println("New place ");
        String newplace = keyb.nextLine();
        System.out.println("New purchase date ");
        String newpurchasedate = keyb.nextLine();
        cat.updateLivres(identifiant, new Livre(newidentifiant, newplace, newpurchasedate));
    }
    
    }
    


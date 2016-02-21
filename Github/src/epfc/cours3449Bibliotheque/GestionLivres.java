/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epfc.cours3449Bibliotheque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 0101nalegier
 */
public class GestionLivres extends Catalogue {
        static Catalogue cat;
        static Scanner keyb = new Scanner(System.in);
       
    public static void main(String[] args) throws FileNotFoundException {
       try{
           printWelcome();
           affichemenu();
        }
       catch(Exception ex){
               System.out.println(ex.getMessage());
               }    
       }

    
    public static void printWelcome(){
        System.out.println("Welcome to the Library application");
        cat = new Catalogue();
     }
    
    public static void affichemenu(){
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
                break;
            case "D":
                break;
            case "Q":
                break;
               
    }
        
    }
       
    public static void find(){
        //method pour lire un record specific
        System.out.println("Enter the identifiant number ");
        String iden = keyb.next();
        cat.findIdentifiant(iden);
        System.out.println(cat);
        
    }
    
    public static void createLivre(){
        try{
            System.out.println("Enter the data to add a livre");
            System.out.println("Ent")
        }
    }

        
    }
    


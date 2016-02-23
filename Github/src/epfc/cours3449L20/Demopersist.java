/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epfc.cours3449L20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 0101nalegier
 */
public class Demopersist {
   
    static ArrayList<Livre> ls = new ArrayList<>();
    static final String nomDeFichier = "livre.csv";
    
    public static void main(String[] args) throws FileNotFoundException {
     
        chargeLivres();
        creeDeuxLivres();
        
    }   

    private static void chargeLivres() throws FileNotFoundException{
        Scanner sc = new Scanner(new File(nomDeFichier));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String [] elements = line.split(";");
            Livre l = new Livre(elements[1],elements[2]);
            ls.add(l);
        }
        
    }
    private static void creeDeuxLivres() throws FileNotFoundException {
        
        Livre l1 = new Livre("Notre Dame", "Victor");
        Livre l2 = new Livre ("Java ...", "Orstmann");
        ls.add(l1);
        ls.add(l2);
        PrintWriter pw = new PrintWriter(new File(nomDeFichier));
        for (Livre l : ls) {   //chaque fois qu'on va dans le for on récupère la valeur de la liste de livre
                               //ls  
            pw.println(l.toCsv());
            
        }
        pw.close();         //permet de fermer le fichier sinon rien ne sera sauvé sur le fichier
            
        }
    }

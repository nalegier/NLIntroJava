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
public class GestionLivres {
        static ArrayList<Livre> livre = new ArrayList<>();
        static Scanner keyb = new Scanner(System.in);
       
    public static void main(String[] args) throws FileNotFoundException {
       try{
            lirefichier();
            imprimerLivre(livre);
            affichemenu();
        }
    catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
       catch(Exception ex){
               System.out.println(ex.getMessage());
               }    
       }

    public static ArrayList<Livre> lirefichier() throws FileNotFoundException{
           //method to read the input file
       
          File file = new File("livres.txt");  
          System.out.println("Input file location " + file.getAbsolutePath());
          //print the file location
          Scanner inputfile = new Scanner(file);
            while (inputfile.hasNext()){
                //loop until there is no more line
                String l1 = inputfile.nextLine();
                livre.add(parseCSVFile(l1));
               
            }
            inputfile.close();
            return livre;
        }
        
        public static Livre parseCSVFile(String line){
            //method to parse the input file into Livre object
            List<String> input = Arrays.asList(line.split(";"));
            String identifiant = input.get(0);
            String place = input.get(1);
            String dateachat = input.get(2);            
            
            return new Livre(identifiant, place, dateachat);
            
        }
        
    
    public static void imprimerLivre(ArrayList<Livre> livre) throws FileNotFoundException{
        //method to write the output file
        PrintWriter out = new PrintWriter("livres.txt");
        for (int i = 0; i<livre.size(); i++){
            //System.out.println(livre.get(i).getIdentifiant());
            //System.out.println(livre.get(i).getPlace());
            //System.out.println(livre.get(i).getDateAchat());
            out.println(livre.get(i).toCSV());
        }      
        System.out.println("Le fichier est mis à jour");
        out.close();
    }
    
    public static void affichemenu(){
        //method pour afficher un menu
        System.out.println("Taper C(Create) ou R(read) ou U(update) ou D(delete) : " );
        String choix = keyb.nextLine();
        choix = choix.toUpperCase();
        switch(choix){
            case "C":
                
            case "R":
                read();
            case "U":
            case "D":    
    }
        
    }
       
    public static void read(){
        //method pour lire un record specific
        System.out.println("Entrez le numéro d'identifiant: ");
        String iden = keyb.next();
        findIdentifiant(iden);
    }
    

        
    }
    


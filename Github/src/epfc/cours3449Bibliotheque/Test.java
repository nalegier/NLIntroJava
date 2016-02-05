//script to scan the books

package epfc.cours3449Bibliotheque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
    
    static Scanner keyb = new Scanner(System.in);
    static ArrayList<Livre> livre = new ArrayList<Livre>();
       
    public static void main(String[] args) throws FileNotFoundException {
       try{
            boolean encore = true;
            lirefichier();
            imprimerLivre(livre);
        }
       catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
    }   
        public static void lirefichier() throws FileNotFoundException{
            
        ///Livre livre = null;
          File file = new File("LivresInput.txt");  
          ///Scanner inputfile = new Scanner(new File("LivresInput.txt"));
          Scanner inputfile = new Scanner(file);
            ///Livre livre = null;
            while (inputfile.hasNext()){
                String l1 = inputfile.nextLine();
                livre.add(parseCSVFile(l1));
                
            }
            System.out.println(inputfile.getPath());
             inputfile.close();
        }
        
        public static Livre parseCSVFile(String line){
             Scanner lineScanner = new Scanner(line);
             lineScanner.useDelimiter(";");
             String identifiant = null, place = null, dateachat = null;
             while (lineScanner.hasNext()) {
                identifiant = lineScanner.next();
                place = lineScanner.next();
                dateachat = lineScanner.next();
             }
             System.out.println(lineScanner);
             return new Livre(identifiant, place, dateachat);
            
        }
        
    
    public static void imprimerLivre(ArrayList<Livre> livre) throws FileNotFoundException{
        PrintWriter out = new PrintWriter("livres.txt");
        for (int i = 0; i<livre.size(); i++){
            System.out.println("L'identifiant: " + livre.get(i).getIdentifiant());
            System.out.println("La place: " + livre.get(i).getPlace());
            System.out.println("La date d'achat: " + livre.get(i).getDateAchat());
            out.println(livre.get(i).toCSV());
        }      
        out.close();
    }
    
   
    public static Livre addlivre(){
         System.out.println("Entrez l'identifiant: ");
         String identifiant = keyb.nextLine();
         System.out.println("Entrez la place :");
         String place = keyb.nextLine();
         System.out.println("Entrez la date d'achat: ");
         String dateachat = keyb.nextLine();
            return new Livre(identifiant, place, dateachat);
     }   
    
      
    public static boolean stopouencore(){
        boolean encore = true;
        boolean next = true;
        while (next){
            System.out.println("Encore un autre livre (Y/N): ");
            // Sttering nextLine = keyb.nextLine();
            String choix = keyb.nextLine();
            choix = choix.toUpperCase();
            if (choix.length() == 0){
                choix = keyb.nextLine();
            }
            switch(choix){
                case "N":
                    encore = false;
                    next = false;
                    break;
                case "Y":
                    ///encore = true;
                    next = false;
                    break;
                default:
                    System.out.println("Choix incorrect");
            }
        }
        return encore;
    }    
    }
     
        
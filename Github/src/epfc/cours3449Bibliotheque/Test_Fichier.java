//script to scan the books

package epfc.cours3449Bibliotheque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Test_Fichier {
    
    static ArrayList<Livre> livre = new ArrayList<>();
       
    public static void main(String[] args) throws FileNotFoundException {
       try{
            lirefichier();
            imprimerLivre(livre);
        }
       catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
    }   
        public static ArrayList<Livre> lirefichier() throws FileNotFoundException{
           //method to read the input file
          File file = new File("InputFile.txt");  
          System.out.println(file.getAbsolutePath());
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
        PrintWriter out = new PrintWriter("OutputFiles.txt");
        for (int i = 0; i<livre.size(); i++){
            System.out.println("L'identifiant: " + livre.get(i).getIdentifiant());
            System.out.println("La place: " + livre.get(i).getPlace());
            System.out.println("La date d'achat: " + livre.get(i).getDateAchat());
            out.println(livre.get(i).toCSV());
        }      
        out.close();
    }
       
    }
     
        
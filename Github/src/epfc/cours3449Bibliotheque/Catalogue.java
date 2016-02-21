//creation of Catalogue
//  with add livre, update livre, delete livre, read livre and find lire

package epfc.cours3449Bibliotheque;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natacha
 */
public class Catalogue {
    
     static ArrayList<Livre> livres = new ArrayList<>();
    //ArrayList<Livre> livres; 
    String fichier = "livres.txt";
    String separator = ";";
    
    public Catalogue() throws BusinessException{
        loadfichier();
    }
    
    private void loadfichier() throws BusinessException{
        try {
          File file = new File(fichier);  
          System.out.println("Input file location " + file.getAbsolutePath());
          //print the file location
          if (!file.exists()){
              file.createNewFile();
          }
          Scanner inputfile = new Scanner(file);
            while (inputfile.hasNext()){
                //loop until there is no more line
                String [] values = (inputfile.nextLine()).split(separator);
                //livres.add(parseCSVFile(l1));
                livres.add(new Livre(values[0], values[1], values[2]));
            }
        }
        catch (IOException | ArrayIndexOutOfBoundsException ex){
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE,null,ex);
            throw new BusinessException("Impossible to load DB file " + fichier);
        }
    }
   /** 
    private Livre parseCSVFile(String line){
            //method to parse the input file into Livre object
            List<String> input = Arrays.asList(line.split(separator));
            String identifiant = input.get(0);
            String place = input.get(1);
            String dateachat = input.get(2);            
       
       return new Livre(identifiant, place, dateachat);
            
    }        
    **/
     private void savefile() throws BusinessException{
        try ( //method to write the output file
                PrintWriter out = new PrintWriter("livres.txt")) {
            for (Livre livre : livres) {
                out.println(livre.toCSV());
            }
            //System.out.println("Le fichier est mis à jour");
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException("Impossible de sauve le fichier " + fichier);
            
        }
    }
     
    public Livre findIdentifiant(String identifiant) {
        // return the livre corresponding to the identifiant provided in input parameter
        boolean found = false;
        for (Livre livre : livres) {
                if (livre.getIdentifiant().equals(identifiant)) {
                found = true;
                return livre;
            }
        }   
        if (found == false){
           System.out.println("Identifiant inconnu");
        }
         return null;
       
    } 
     
    public Livre findPlace (String place){
        // return the livres which contains the place provided in input parameter
        
        boolean found = false;
        for (Livre livre : livres) {
            if (livre.getPlace().contains(place)) {
                found = true;
                return livre;
            }
        }
        if (found == false){
            System.out.println("Place Inconnue");
        }
        return null;
    }
  public boolean identifiantExist(String identifiant){
      //return true if the identifiant provided in input parameter exists
        return findIdentifiant(identifiant) != null;    
    }
  
  public void addLivres(Livre livre) throws BusinessException{
      //add a livre au catalogue if the identifian does not exist yet
      if (identifiantExist(livre.getIdentifiant())) {
          throw new BusinessException("Identifiant exists already " + livre.getIdentifiant());
      }
      livres.add(livre);
      savefile();
      }
   
  
  public void deleteLivres(String identifiant) throws BusinessException {
      // delete le livre corresponding to the identifiant provided in input parameter
      Livre l1 = findIdentifiant(identifiant);
      livres.remove(l1);
      savefile();
      
  }
  
  public void updateLivres(String identifiant, Livre livre) throws BusinessException {
      //update le livre corresponding to the identifiant provided in inpput parameter
      Livre l1 = findIdentifiant(identifiant);
      l1.setIdentifiant(livre.getIdentifiant());
      l1.setPlace(livre.getPlace());
      l1.setDateAchat(livre.getDateAchat());
      savefile();
  }
  
  public void listeFile() throws BusinessException {
      for(Livre livre : livres){
          System.out.println(livre.toString());
      }
  }
          
}
          

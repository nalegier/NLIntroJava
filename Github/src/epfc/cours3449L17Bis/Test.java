
package epfc.cours3449L17Bis;

import java.util.Scanner;


public class Test {
  static Scanner keyb = new Scanner(System.in);
  
    public static void main(String[] args) {
        boolean encore;
        encore = true;
        Adresse ad;
        System.out.println("Entrez le nom de la personne: ");
        String nom = keyb.next();
        Personne personne = new Personne(nom);   
        while(encore){
            personne.addAdresse(ajoutAdresse());
            encore = stopouencore();
        }       
        imprimerDonner(personne);    
        }
    
    public static boolean stopouencore(){
        boolean encore = true;
        System.out.println("Encore une autre adresse (Y/N): ");
      /// String nextLine = keyb.nextLine();
        String choix = keyb.next().toUpperCase();
            switch(choix){
                case "N":
                    encore = false;
                    break;
                case "Y":
                    encore = true;
                    break;
                default:
                    System.out.println("Choix incorrect");
                    keyb.nextLine();
                    stopouencore();
                    break;
            }
            return encore;
    }
    
     public static Adresse ajoutAdresse(){
         System.out.println("Veuillez entrez la rue: ");
         String rue = keyb.next();
         System.out.println("Veuillez entre la ville: ");
         //keyb.nextLine();
         String ville = keyb.next();
         return new Adresse(rue, ville);
        
    }
     
     public static void imprimerDonner(Personne personne){
         System.out.println("Le nom de la personne est " + personne.getNom());
         for (int i=0; i < personne.getSize(); i++){
             System.out.println("Adresse " + i + " " + personne.getAdresse(i));
         } 
     }
}


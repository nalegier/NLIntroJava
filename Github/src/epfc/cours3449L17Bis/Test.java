
package epfc.cours3449L17Bis;

import java.util.Scanner;


public class Test {
  Scanner keyb = new Scanner(System.in);
  
    public static void main(String[] args) {
        boolean encore;
        encore = true;
        Adresse ad;
        System.out.println("Entrez le nom de la personne: ");
        String nom = keyb.next();
        Personne p = new Personne(nom);   
        while(encore){
            System.out.println("Veuillez entrez la rue: ");
            String rue = keyb.next();
            System.out.println("Veuillez entre la ville: ");
            String ville = keyb.next();
            new Adresse(rue, ville);
            
        }
        
        
        
    }
    public void addAdress(){
        
    }
}


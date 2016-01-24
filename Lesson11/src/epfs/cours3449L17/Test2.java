
package epfs.cours3449L17;
// test 2

import java.util.Scanner;

public class Test2 {
 static Scanner keyb = new Scanner(System.in);
 static Cube c = new Cube();
 
 public static void main(String[] args) {
    
        ///Cube c = new Cube();
        boolean encore = true;
        while(encore){
            longueur();
            couleur();
            caractere();
            encore = false;
        }
        System.out.println("La longueur est " + c.getLength());
        System.out.println("Les couleurs sont: " + c.getColor1() + " et " + c.getColor2() + " et " + c.getColor3());
        System.out.println("La chaîne de caractère est " + c.getNom());
 }    
    private static void longueur(){
        boolean encore = true;
        while(encore){
            try {
                System.out.println("Entrez la longueur: ");
                int length = keyb.nextInt();
                c.SetLength(length);
                encore = false;
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                keyb.nextLine();
            }
        }
        keyb.nextLine();
    }
    
    private static void couleur(){
        boolean encore = true;
        while(encore){
            try {
                System.out.println("Entrez 3 chiffres pour la couleur");
                int col1 = keyb.nextInt();
                int col2 = keyb.nextInt();
                int col3 = keyb.nextInt();
                c.SetColor(col1, col2, col3);
                encore = false;
            }
            catch(IllegalArgumentException ex{
                System.out.println(ex.getMessage());
                keyb.nextLine();
                
            }
        }
        keyb.nextLine();
    }
    private static void caractere(){
        boolean encore = true;
        ///keyb.nextLine();
        while(encore){
            try {
                 System.out.print("Entrez un string entre 3 à 15: ");
                 String mot = keyb.nextLine();
                 c.SetName(mot);
                 encore = false;
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                keyb.nextLine();
            }
        }
    }
    
}


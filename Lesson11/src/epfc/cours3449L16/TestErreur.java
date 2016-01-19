
package epfc.cours3449L16;

import java.util.Scanner;

/**
 *
 * @author 0101nalegier
 */
public class TestErreur {
    public static void main(String[] args) {
    Scanner keyb = new Scanner(System.in);
    boolean encore = true;
    while(encore)
    {    
        try {
            System.out.println("Entrez 2 chiffres pour l'adition: ");
            int n = keyb.nextInt();
            int n2 = keyb.nextInt();
            System.out.println("Somme " + (n + n2));
            encore = false;
        } catch (Exception ex) {
            System.out.println("Incorrect, il faut 2 entiers");
            keyb.next();  // to force java to reinitialise la valeur mise dans le keyboard sinon on boucle
        } 
    }    
    System.out.println("Vous avez fini");
}
}

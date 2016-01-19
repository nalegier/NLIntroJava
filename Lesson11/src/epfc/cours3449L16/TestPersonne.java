
package epfc.cours3449L16;

import java.util.Scanner;

/**
 *
 * @author 0101nalegier
 */
public class TestPersonne {
    public static void main(String[] args) {
        Person p = new Person();
        boolean encore = true;
        Scanner keyb = new Scanner(System.in);
        while (encore){
            try {
                System.out.println("Entrer un age");
                int age = keyb.nextInt();
                p.setAge(age);
                encore = false;
        } catch (IllegalArgumentException ex){
            System.out.println(ex);
            keyb.nextLine();
            
        }
                
    }
    }
}

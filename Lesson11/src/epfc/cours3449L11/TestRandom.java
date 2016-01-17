/*
 * 8.6.2 The Random class
 * page 309
 */

package epfc.cours3449L11;

import java.util.Random;
//import java.util.Scanner;

public class TestRandom {
    public static void main(String[] args) {
        //Scanner keyboard = new Scanner(System.in);
        //System.out.print("Entrez 2 chiffres: ");
        //int value = keyboard.nextInt();
        //int value2 = keyboard.nextInt();
        //PrintRandom(value);
        //PrintRandom(value2);
        for (int j = 0; j < 2; j++){
            Random r1 = new Random(3);
            for(int i = 0; i < 10; i++){
                System.out.print(r1.nextInt(1000) + " ");
            }
            System.out.println();
        }
        
    }
}
        /*public static void PrintRandom(int value){
            Random r1 = new Random(value);
            for(int i = 0; i < 10; i++){
                System.out.print(r1.nextInt(1000) + " ");
            }
            System.out.println();
        /*}
}


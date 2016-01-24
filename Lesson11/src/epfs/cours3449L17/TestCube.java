
package epfs.cours3449L17;
//to test my cube class

public class TestCube {
    public static void main(String[] args) {
    
        Cube c = new Cube();
        ///Scanner keyb = new Scanner(System.in);
        boolean encore = true;
        while(encore){
           
            try {
                System.out.println("Entrez la longueur: ");
                int length = keyb.nextInt();
                c.SetLength(length);
                System.out.println("Entrez 3 chiffres pour la couleur");
                int col1 = keyb.nextInt();
                int col2 = keyb.nextInt();
                int col3 = keyb.nextInt();
                c.SetColor(col1, col2, col3);
                keyb.nextLine();
                System.out.print("Entrez un string entre 3 à 15: ");
                String nom = keyb.nextLine();
                c.SetName(nom);
                encore = false;
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            keyb.nextLine();
        }    
        catch(Exception ex2){
                System.out.println(ex2.getMessage());
                keyb.nextLine();
        }    
}
}
    public void setLenght(){
        try {
            System.out.println("Entrez la longueur: ");
            
        
    }
}

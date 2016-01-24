
package epfc.cours3449L17;

///creation d'une classe cube

public class Cube {
    private int length;
    private int color1, color2, color3;
    private String nom;

    public int getLength() {
        return length;
    }

    public int getColor1() {
        return color1;
    }

    public int getColor2() {
        return color2;
    }

    public int getColor3() {
        return color3;
    }

    public String getNom() {
        return nom;
    }
    
    
    public void SetLength(int length ){
        if (length < 0 || length == 0){
            throw new IllegalArgumentException("La longueur doit être positif et plus grand que 0");
        }   
        else
            this.length = length;
        }
    
    public void SetColor(int col1, int col2, int col3){
        if (col1 < 0 || col1 > 255) {
            throw new IllegalArgumentException("Chiffre 1 hors limite [0-255]");
        } else {
            if (col2 < 0 || col2 > 255) {
                throw new IllegalArgumentException("Chiffre 2 hors limite [0-255]");
            } else {
            if (col3 < 0 || col3 > 255) {
                throw new IllegalArgumentException("Chiffre 3 hors limite [0-255]");
            }
            }
        }
        this.color1 = col1;
        this.color2 = col2;
        this.color3 = col3;
    }
    public void SetName(String nom){
        if (nom.length()<3 || nom.length()>15){
            throw new IllegalArgumentException("Le nom doit comporter entre [3-15] caractères");
        }
        this.nom = nom;
    }
    }


package epfc.cours3449L20;

/**
 *
 * @author 0101nalegier
 */
public class Livre {
    private static int count = 0;
    private int id;   //id technique unique
    private String titre;
    private String auteur;
    
    public Livre(String titre, String auteur){
        count++;
        this.id = count;
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    public String toCsv(){
        return id + ";" + titre + ";" + auteur ;
    }
}


package epfc.cours3449Bibliotheque;
//definition de la classe Livre

public class Livre {
    private String identifiant;
    private String place;
    private String dateachat;

    public Livre(){
        this.identifiant = null;
        this.place = null;
        this.dateachat = null;
    }
    
    public Livre(String identifiant,String place, String dateachat) {
        this.place = place;
        this.dateachat = dateachat;
        this.identifiant = identifiant;
        
    }

    public String getPlace() {
        return place;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getDateachat() {
        return dateachat;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDateachat(String dateachat) {
        this.dateachat = dateachat;
    }

    @Override
    public String toString() {
        return "Livre{" + "identifiant=" + identifiant + ", place=" + place + ", dateachat=" + dateachat + '}';
    }
    
    
    
    
    
    
    
}

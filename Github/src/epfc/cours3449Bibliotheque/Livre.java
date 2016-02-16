
package epfc.cours3449Bibliotheque;
//definition de la classe Livre

public class Livre {
    private String identifiant;
    private String place;
    private String dateAchat;

    public Livre(){
        this.identifiant = null;
        this.place = null;
        this.dateAchat = null;
    }
    
    public Livre(String identifiant,String place, String dateachat) {
        this.place = place;
        this.dateAchat = dateachat;
        this.identifiant = identifiant;
        
    }

    public String getPlace() {
        return place;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    @Override
    public String toString() {
        return "Livre{" + "identifiant=" + identifiant + ", place=" + place + ", dateachat=" + dateAchat + '}';
    }
    
    public String toCSV(){
        return identifiant + ";" + place + ";" + dateAchat;
    }

}

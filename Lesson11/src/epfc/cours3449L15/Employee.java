
package epfc.cours3449L15;

public class Employee extends Travailleur implements InterfacePointage{
    String employeur;

    @Override
    public double calculImpots() {
        return (getRevenu()/1.6);
    }
    
    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getEmployeur() {
        return employeur;
    }

    @Override
    public void pointer() {
        System.out.println("Travailleur pointe");
    }

    @Override
    public void demanderConger() {
        System.out.println("Travailleur demande congé");
    }
      
}

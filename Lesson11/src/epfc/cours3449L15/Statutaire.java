
package epfc.cours3449L15;

public class Statutaire extends Travailleur implements InterfacePointage{

    @Override
    public double calculImpots() {
       return (getRevenu()/1.5);
    }

    @Override
    public void pointer() {
        System.out.println("Tous les jours, le statutaire pointe");
    }

    @Override
    public void demanderConger() {
        System.out.println("Le statutaire doit demander ses congés");
    }
    
}

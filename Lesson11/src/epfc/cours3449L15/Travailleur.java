package epfc.cours3449L15;
// Creation d'une classe abstraite Travailleur

public abstract class Travailleur {
    private double revenu = 0;
    
    public abstract double calculImpots();

    public double getRevenu() {
        return revenu;
    }

    public void setRevenu(double revenu) {
        this.revenu = revenu;
    }
    
}
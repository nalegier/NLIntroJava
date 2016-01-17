
package epfc.cours3449L15;

public class TestTravailleur {

    public static void main(String[] args) {
        Independant i = new Independant();
        Employee e = new Employee(); 
        Statutaire s = new Statutaire();
        i.setRevenu(50000.0);
        System.out.println("Le revenu d'un indépendant : " + i.getRevenu());
        System.out.println("Impôt de l'indépendant : " + i.calculImpots());
        System.out.println();
        e.setRevenu(5000.0);
        e.setEmployeur("BASE");
        System.out.println("Le revenu d'un employee: " + e.getRevenu());
        System.out.println("L'employeur est " + e.getEmployeur());
        System.out.println("Impôt de l'employee: " + e.calculImpots());
        e.pointer();
        e.demanderConger();
        System.out.println();
        s.setRevenu(1500.0);
        System.out.println("L'impôt d'un statutaire: " + s.calculImpots());
        s.pointer();
        s.demanderConger();
        
    }
}

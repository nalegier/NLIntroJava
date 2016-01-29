
package epfc.cours3449L17Bis;

/**
 *
 * @author 0101nalegier
 */
public class Test {

    public static void main(String[] args) {
        Personne p = new Personne("Alfred", new Adresse("Les Maisons 45", "XL"), "9506143607");
        System.out.println(p.getNom() + " " + p.getAdresse() + " " + p.getNumeroNation());
        p.getAdresse().setRue("Du Coq");
        System.out.println(p.getNom() + " " + p.getAdresse() + " " + p.getNumeroNation());
        
    }
}

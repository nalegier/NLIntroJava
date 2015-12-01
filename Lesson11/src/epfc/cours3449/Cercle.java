

package epfc.cours3449;

/**
 *
 * @author 0101nalegier
 */
public class Cercle {
    static int nrInstance = 0;
    double rayon;

    
    public Cercle(double rayon) {
        this.rayon = rayon;
        nrInstance++;
    }
    public Cercle() {
    }
    public double getAire(){
        return Math.PI*rayon*rayon;
    }
    
}

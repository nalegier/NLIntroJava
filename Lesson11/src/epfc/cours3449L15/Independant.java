//creation d'une classe indépendant

package epfc.cours3449L15;
// * @author Natacha

public class Independant extends Travailleur {
        String nrEntreprise;
        
   @Override
    public double calculImpots() {
        return getRevenu()/10;
    }
        public void setNrEntreprise(String nrEntreprise){
            this.nrEntreprise = nrEntreprise;
        }
        public String nrEntreprise(){
            return nrEntreprise;
        }
}


package epfc.cours3449ImprimerFacture;

public class LineItem {
    private int quantity;
    private Product theProduct;

    public LineItem(int quantity, Product theProduct) {
        this.quantity = quantity;
        this.theProduct = theProduct;
    }
    
    public double getTotalPrice(){
        return theProduct.getPrice() * quantity;
    }
    
    public String formatLine(){
        return String.format("%-30s%8.2f%5d%8.2f", theProduct.getDescription(),theProduct.getPrice(), 
                quantity, this.getTotalPrice());
                
    }
}

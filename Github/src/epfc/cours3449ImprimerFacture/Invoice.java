
package epfc.cours3449ImprimerFacture;

import java.util.ArrayList;

public class Invoice {
    private Address billingaddress;
    private ArrayList<LineItem> items;
    
    
    public Invoice(Address anAddress){
        items = new ArrayList<LineItem>();
        this.billingaddress = anAddress;
        
    }
    
    //method to add a product to the LineItem class
    public void addProduct(Product aProduct, int quantity){
        LineItem anItem = new LineItem(quantity, aProduct);
        items.add(anItem);
    }
    
    public double getTotalInvoice(){
        double total = 0;
        for (LineItem items: items){
            total = total + items.getTotalPrice();
        }
        return total;
    }
    
    public String formatInvoice(){
        String r = "                     I N V O I C E\n\n"
        + billingaddress.formatAddress()
        + String.format("\n\n%-30s%8s%5s%8s\n", "Description", "Price", "Qty", "Total");
        
        for(LineItem items: items){
            r = r + items.formatLine() + "\n";
        }
        r = r + String.format("\n%-20s%8.2f","Total Invoice = ", getTotalInvoice()) + "€";
        return r;
    }
    
}         

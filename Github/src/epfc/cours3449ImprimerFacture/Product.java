
package epfc.cours3449ImprimerFacture;
//description of the product class which contains the name of the product and its price

public class Product {
    private double price;
    private String description;

    
    public Product(double price, String description) {
    // default constructor
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
   
}

  

    


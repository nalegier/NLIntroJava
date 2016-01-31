
package epfc.cours3449ImprimerFacture;

public class PrintInvoice {
      public static void main(String[] args) {
          
          Address myAddress = new Address("Natacha Legier", "Kwakkelstraat 19", "Vilvoorde", "1800","Belgium");
          Invoice myInvoice  = new Invoice(myAddress);
          myInvoice.addProduct((new Product(2.45,"Toaster")),5);
          myInvoice.addProduct((new Product(5.0,"Iron")),2);
          myInvoice.addProduct(new Product(400.00,"Dish Washer"), 1);
          myInvoice.addProduct(new Product(1500.00,"Electrical Cooker"), 2);
          System.out.println(myInvoice.formatInvoice());
          
      }
            
            
            
            
            
            
            
}

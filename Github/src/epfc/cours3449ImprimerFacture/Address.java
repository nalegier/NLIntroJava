
package epfc.cours3449ImprimerFacture;
// class which defines the billing address

public class Address {
    private String name;
    private String street;
    private String city;
    private String postcode;
    private String country;

    //default constructor
    
    public Address(String name, String street, String city, String postcode, String country) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }
    
    public String formatAddress(){
        return name + "\n" + street + "\n" + postcode + " " + city + "\n" + country;
    }
}

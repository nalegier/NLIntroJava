package epfc.cours3449L22Devoir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Catalogue {
   
    public Catalogue(){
 }
    
    public void add(Livre l) {
        // insert with value for title and author
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String addsql = "insert into catalogue (titre,auteur) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(addsql);
            String autor = l.getAuteur();
            String title = l.getTitre();
            statement.setString(1, title);
            statement.setString(2, autor);
            statement.executeUpdate();
            connection.close();
    }
    catch (Exception e){
            System.err.println("Got an exception on adding record!");
            System.err.println(e.getMessage());
        }
   }

    public void update(int id, Livre l) {
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String updatesql = "update catalogue set titre = ?, autor = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(updatesql);
            String titre = l.getTitre();
            String auteur = l.getAuteur();
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setInt(3, id);
            statement.executeUpdate();
            connection.close();
    }
    catch (Exception e) {
        System.err.println("Got an exception on update!");
        System.err.println(e.getMessage());
    }
    }    


    public void delete(int id) throws Exception {
  
    }
    

    ArrayList<Livre> read() {
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            Statement statement = connection.createStatement();
             
            // to execute a select
            ResultSet resultSet = statement.executeQuery
            ("select * from catalogue");
             
            ArrayList<Livre> listelivres = new ArrayList<>();
            // to show the result of the select command
            while (resultSet.next()) {
                System.out.println
                (resultSet.getString(1) + " - " +
                resultSet.getString(2) + " - " + 
                resultSet.getString(3));
                Livre l = new Livre(
                     resultSet.getInt(1), 
                     resultSet.getString(2), 
                     resultSet.getString(3));
                listelivres.add(l);
        }
        //for (Livre livre: listelivres){
        //    System.out.println(livre.toString());
        //}
        connection.close();
    }
    catch (Exception e) {
        System.err.println("Got an exception !!!");
        System.err.println(e.getMessage());
}    
        return null;
}
    
   
    ArrayList<Livre> readByAuteur(String auteur) {
        ArrayList<Livre> lsDeAuteur = new ArrayList<>();
        Iterable<Livre> ls = null;
        for (Livre livre : ls) {
            if (livre.getAuteur().equals(auteur)) {
                lsDeAuteur.add(livre);
            }
        }
        return lsDeAuteur;
    }
}

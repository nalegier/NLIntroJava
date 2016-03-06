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
        // insert a new record in table "catalogue" with value for title and author
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String sql = "insert into catalogue (titre,auteur) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            String author = l.getAuteur();
            String title = l.getTitre();
            statement.setString(1, title);
            statement.setString(2, author);
            statement.executeUpdate();
            connection.close();
    }
    catch (Exception e){
            System.err.println("Got an exception on adding record!");
            System.err.println(e.getMessage());
        }
   }

    public void update(int id, Livre l) {
        //update a record in table catalogue.  To find the book to update the id is given as input parameter
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String sql = "update catalogue set titre = ?, auteur = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
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


    public void delete(int id){
        //delete a record in table catalogue by using the id as input parameter
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String sql = "delete from catalogue where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
    }
    catch (Exception e) {
        System.err.println("Got an exception on delete !");
        System.err.println(e.getMessage());
    }
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
                Livre l = new Livre(
                     resultSet.getInt(1), 
                     resultSet.getString(2), 
                     resultSet.getString(3));
                listelivres.add(l);
        }
         connection.close();
         return listelivres;
    }
    catch (Exception e) {
        System.err.println("Got an exception !!!");
        System.err.println(e.getMessage());
}    
 return null;      
}
    
   
    ArrayList<Livre> readByAuteur(String auteur) {
         //find all the books with the same author
        try{
            Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "nanou1831");
            String sql = "select * from catalogue where author = ?";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ArrayList<Livre> lsDeAuteur = new ArrayList<>();
            while(result.next()){
                int id = result.getInt(1);
                String title = result.getString(2);
                String author = result.getString(3);
                Livre l = new Livre(id, title, author);
                lsDeAuteur.add(l);
                    
                }
            connection.close();
            return lsDeAuteur;
    }
    catch (Exception e) {
        System.err.println("Got an exception on Find !");
        System.err.println(e.getMessage());
    }
    return null;     
    }
}    

package epfc.cours3449L22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //charger le driver pour MySql
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root", "");
        Statement statement = connection.createStatement();
        //statement.executeUpdate ("create table if not exists temp (col1 char(5), col2 varchar(5))");
        
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
        for (Livre livre: listelivres){
            System.out.println(livre.toString());
        }
        String sql = "insert into catalogue (titre, auteur)" 
                + " values('Les fleurs du mal', 'Pascal')";
        statement.executeUpdate(sql);
        
    }
}

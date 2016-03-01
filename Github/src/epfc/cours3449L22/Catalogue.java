package epfc.cours3449L22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalogue {
   
    public Catalogue(String nomDeFichier) throws FileNotFoundException, IOException {
        this.nomDeFichier = nomDeFichier;
        charge();
    }

    public void add(Livre l) {
        // 
    }

    public void update(Livre l) throws Exception {
        for (Livre livre : ls) {
            if (livre.getId() == l.getId()) {
                livre.setTitre(l.getTitre());
                livre.setAuteur(l.getAuteur());
                return;
            }
        }
        throw new Exception("Livre pas trouvé");
    }

    public void delete(int id) throws Exception {
        for (Livre livre : ls) {
            if (livre.getId() == id) {
                ls.remove(livre);
                sauve();
                return;
            }
        }
        throw new Exception("Livre pas trouvé");
    }

    Livre read(int id) throws Exception {
        for (Livre livre : ls) {
            if (livre.getId() == id) {
                return livre;
            }
        }
        throw new Exception("Livre pas trouvé");
    }

    ArrayList<Livre> read() throws ClassNotFoundException, SQLException {
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
    }

    ArrayList<Livre> readByAuteur(String auteur) {
        ArrayList<Livre> lsDeAuteur = new ArrayList<>();
        for (Livre livre : ls) {
            if (livre.getAuteur().equals(auteur)) {
                lsDeAuteur.add(livre);
            }
        }
        return lsDeAuteur;
    }

    private void charge() throws FileNotFoundException, IOException {
        File file = new File(nomDeFichier);
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            int id = Integer.getInteger(elements[0]);
            Livre l = new Livre( id, elements[1], elements[2]);
            ls.add(l);
        }
    }

    private void sauve() {
        PrintWriter pw = null;
        try {
            File f = new File(nomDeFichier);
            pw = new PrintWriter(f);
            for (Livre l : ls) {
                pw.println(l.toCsv());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Exception " + ex);
        } finally {
            pw.close();
        }
    }
}

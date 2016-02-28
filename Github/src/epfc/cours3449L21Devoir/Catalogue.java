package epfc.cours3449L21Devoir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Catalogue {

    private final String nomDeFichier;
    private final String fichierTemp = "Temp.csv";

    public Catalogue(String nomDeFichier) throws FileNotFoundException, IOException {
        this.nomDeFichier = nomDeFichier;
        openFile();
    }

  
    private void openFile() throws FileNotFoundException {
        File file = new File(nomDeFichier);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void readFile () throws FileNotFoundException{
        File file = new File(nomDeFichier);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            int id = Integer.parseInt(elements[0]);
            Livre l = new Livre( id, elements[1], elements[2]);
            System.out.println(l.toString());
        }
    }    
    
    public void ajoutLigne(Livre l) throws FileNotFoundException, IOException {
        openFile();
        File file = new File(nomDeFichier);
        try (FileWriter fw = new FileWriter(file,true)) {
            fw.write("\n");
            fw.write(l.toCsv());
            fw.close();
        }
           
    }
    
    public void deleteUnLivre(String identifiant) throws FileNotFoundException, IOException {
        openFile();
        File file = new File(nomDeFichier);
        Scanner sc = new Scanner(file);
        File fileTemp = new File(fichierTemp);
        createTemp(fileTemp);
        FileWriter fw = new FileWriter(fileTemp,true);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            if(!identifiant.equals(elements[0])){
                //int id = Integer.parseInt(elements[0]);
                Livre l = new Livre(elements[1], elements[2]);
                fw.write(l.toCsv());
                fw.write("\n");
            }
        }
        fw.close();
        ////copyFileUsingStream(fileTemp, file);
    }
    
    public void createTemp(File fichierTemp){
          if (fichierTemp.exists()) {
                fichierTemp.delete();
            }
        try {  
            fichierTemp.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUnLivre(String identifiant) throws FileNotFoundException, IOException{
        openFile();
        File file = new File(nomDeFichier);
        Scanner sc = new Scanner(file);
        Scanner keyb = new Scanner(System.in);
        File fileTemp = new File(fichierTemp);
        createTemp(fileTemp);
        FileWriter fw = new FileWriter(fileTemp,true);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            if(identifiant.equals(elements[0])){
                int id = Integer.parseInt(elements[0]);
                System.out.println("New Title: ");
                String title = keyb.nextLine();
                System.out.println("New Autor: ");
                String autor = keyb.nextLine();
                Livre l = new Livre(id, title, autor);
                fw.write(l.toCsv());
                fw.write("\n");
            }
            else{
                int id = Integer.parseInt(elements[0]);
                Livre l = new Livre(id, elements[1], elements[2]);
                fw.write(l.toCsv());
                fw.write("\n");
            }
        }
        fw.close();
        copyFileUsingStream(fileTemp,file);
    }
    
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
           
        }
    }
 } 
          

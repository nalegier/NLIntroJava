package epfc.cours3449L21Devoir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        fileTemp.renameTo(file);
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
        File fileTemp = new File(fichierTemp);
        createTemp(fileTemp);
        FileWriter fw = new FileWriter(fileTemp,true);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] elements = line.split(";");
            if(identifiant.equals(elements[0])){
                System.out.println("New Title: ");
                
                Livre l = new Livre;
            }
                
            }
    }
} 
          

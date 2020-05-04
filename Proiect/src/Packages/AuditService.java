package Packages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AuditService {
    public static void writeToCSV(String actiune) {
        BufferedWriter bw = null;
        try {
            File file = new File("src/logs.csv");
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Fisierul nu s-a creeat");
                }
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            String mycontent = "" + actiune +
                    ", " +
                    new Date() +
                    "\n";
            bw.write(mycontent);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }

    }
}

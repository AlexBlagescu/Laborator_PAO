package Packages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static CsvWriter ob = null;
    private CsvWriter() {}

    public static CsvWriter getInstance()
    {
        if (ob == null)
            ob = new CsvWriter();
        return ob;
    }

    public void writePacientOm(String fisier, String actiune, Pacient p) {
        BufferedWriter bw = null;
        try {
            File file = new File(fisier);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Fisierul nu s-a creeat");
                }
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            String mycontent = "\n" + p.getNume() +
                    "," +
                    p.getPrenume() +
                    "," +
                    p.getVarsta() +
                    "," +
                    p.getCNP() +
                    "," +
                    p.getSex() +
                    "," +
                    p.isStareDeSanatate() +
                    "," +
                    p.getCodR();
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
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public void writePacientAnimal(String fisier, String actiune, Animale a) {
        BufferedWriter bw = null;
        try {
            File file = new File(fisier);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Fisierul nu s-a creeat");
                }
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            String mycontent = "\n" + a.getNume() +
                    "," +
                    a.getCode() +
                    "," +
                    a.getTip() +
                    "," +
                    a.isStareDeSanatate();
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
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public void writeMedic(String fisier, String actiune, Medic m) {
        BufferedWriter bw = null;
        try {
            File file = new File(fisier);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Fisierul nu s-a creeat");
                }
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            String mycontent = "\n" + m.getNume() +
                    "," +
                    m.getPrenume() +
                    "," +
                    m.getVarsta() +
                    "," +
                    m.getCNP() +
                    "," +
                    m.getSex() +
                    "," +
                    m.getOrar();
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
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public void writeReteta(String fisier, String actiune, Reteta r) {
        BufferedWriter bw = null;
        try {
            File file = new File(fisier);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Fisierul nu s-a creeat");
                }
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            StringBuilder mycontent = new StringBuilder("\n" + r.getCodReteta() + ",");
            for (String s : r.getMedicamente()) {
                mycontent.append(s).append(",");
            }
            mycontent.deleteCharAt(mycontent.lastIndexOf(","));
            bw.write(mycontent.toString());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }
}

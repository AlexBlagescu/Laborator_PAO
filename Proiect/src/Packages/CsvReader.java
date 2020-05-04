package Packages;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CsvReader {
    private static CsvReader ob = null;
    private CsvReader() {}

    public static CsvReader getInstance()
    {
        if (ob == null)
            ob = new CsvReader();
        return ob;
    }
    public  ArrayList<Pacient> readPacientiOameni(String numeFisier) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Pacient> pacientiOameni = new ArrayList<Pacient>(0);
        try {
            br = new BufferedReader(new FileReader(numeFisier));
            int nr = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                nr += 1;
                String[] aux = line.split(cvsSplitBy);
                if (nr != 1) {
                    Pacient p = new Pacient(aux[0], aux[1], Integer.parseInt(aux[2]), Long.parseLong(aux[3]), aux[4], Boolean.parseBoolean(aux[5]), Integer.parseInt(aux[6]));
                    pacientiOameni.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return pacientiOameni;
    }
    public ArrayList<Reteta> readReteta(String numeFisier) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Reteta> reteta = new ArrayList<Reteta>(0);
        try {
            br = new BufferedReader(new FileReader(numeFisier));
            int nr = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                nr += 1;
                String[] aux = line.split(cvsSplitBy);
                if (nr != 1) {
                    HashSet<String> medicamente = new HashSet<String>(0);
                    for (int i = 1; i < aux.length; i++) {
                        medicamente.add(aux[i]);
                    }
                    Reteta a = new Reteta(medicamente, Integer.parseInt(aux[0]));
                    reteta.add(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return reteta;
    }
    public ArrayList<Animale> readPacientiAnimale(String numeFisier) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Animale> pacientiAnimale = new ArrayList<Animale>(0);
        try {
            br = new BufferedReader(new FileReader(numeFisier));
            int nr = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                nr += 1;
                String[] aux = line.split(cvsSplitBy);
                if (nr != 1) {
                    Animale a = new Animale(aux[0], Long.parseLong(aux[1]), aux[2], Boolean.parseBoolean(aux[3]));
                    pacientiAnimale.add(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return pacientiAnimale;
    }
    public ArrayList<Medic> readMedici(String numeFisier) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Medic> medici = new ArrayList<Medic>(0);
        try {
            br = new BufferedReader(new FileReader(numeFisier));
            int nr = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                nr += 1;
                String[] aux = line.split(cvsSplitBy);
                if (nr != 1) {
                    StringBuilder orar = new StringBuilder("");
                    for (int i = 5; i < aux.length; i++) {
                        if (i != aux.length - 1) {
                            orar.append(aux[i]).append(", ");
                        } else {
                            orar.append(aux[i]);
                        }
                    }
                    Medic m = new Medic(aux[0], aux[1], Integer.parseInt(aux[2]), Long.parseLong(aux[3]), aux[4], orar.toString());
                    medici.add(m);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return medici;
    }
}

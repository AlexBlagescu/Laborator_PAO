package Packages;

import java.util.HashSet;

public class Reteta {
    private HashSet<String> medicamente;
    private int codReteta;

    public Reteta(int codReteta) {
        this.medicamente = new HashSet<String>(0);
        this.codReteta = codReteta;
    }
    public Reteta(HashSet<String> medicamente, int codReteta) {
        this.medicamente = medicamente;
        this.codReteta = codReteta;
    }

    public HashSet<String> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(HashSet<String> medicamente) {
        this.medicamente = medicamente;
    }

    public int getCodReteta() {
        return codReteta;
    }

    public void setCodReteta(int codReteta) {
        this.codReteta = codReteta;
    }

    public void afisareRetata() {
        System.out.print("Reteta: ");
        for (String s : this.medicamente) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}

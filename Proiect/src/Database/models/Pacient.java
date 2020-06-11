package Database.models;

import Database.models.Persoana;

public class Pacient extends Persoana {
    private String stareDeSanatate;
    private int codR;

    public Pacient(String nume, String prenume, int varsta, long CNP, String sex, String stareDeSanatate, int codR) {
        super(nume, prenume, varsta, CNP, sex);
        this.stareDeSanatate = stareDeSanatate;
        this.codR = codR;
    }

    public String getStareDeSanatate() {
        return stareDeSanatate;
    }

    public void setStareDeSanatate(String stareDeSanatate) {
        this.stareDeSanatate = stareDeSanatate;
    }

    public int getCodR() {
        return codR;
    }

    public void setCodR(int codR) {
        this.codR = codR;
    }
}


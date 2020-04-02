public class Pacient extends Persoana {
    private boolean stareDeSanatate;
    private int codR;

    public Pacient(String nume, String prenume, int varsta, long CNP, String sex, boolean stareDeSanatate, int codR) {
        super(nume, prenume, varsta, CNP, sex);
        this.stareDeSanatate = stareDeSanatate;
        this.codR = codR;
    }

    public boolean isStareDeSanatate() {
        return stareDeSanatate;
    }

    public void setStareDeSanatate(boolean stareDeSanatate) {
        this.stareDeSanatate = stareDeSanatate;
    }

    public int getCodR() {
        return codR;
    }

    public void setCodR(int codR) {
        this.codR = codR;
    }

    public void afisarePacienti() {
        super.afisarePersoane();
        System.out.print("Stare de sanatate Pacient: ");
        if (this.isStareDeSanatate()) {
            System.out.println("Sanatos");
        } else {
            System.out.println("Bolnav");
        }
    }
}

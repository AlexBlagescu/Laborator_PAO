package Packages;

public class Animale {
    private String nume;
    private long code;
    private String tip;
    private boolean stareDeSanatate;

    public Animale(String nume, long code, String tip, boolean stareDeSanatate) {
        this.nume = nume;
        this.code = code;
        this.tip = tip;
        this.stareDeSanatate = stareDeSanatate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isStareDeSanatate() {
        return stareDeSanatate;
    }

    public void setStareDeSanatate(boolean stareDeSanatate) {
        this.stareDeSanatate = stareDeSanatate;
    }
    public void afisarePacienti() {
        System.out.println();
        System.out.print("Nume: ");
        System.out.println(this.getNume());
        System.out.print("Cod: ");
        System.out.println(this.getCode());
        System.out.print("Tip: ");
        System.out.println(this.getTip());
        System.out.print("Stare de sanatate: ");
        if (this.isStareDeSanatate()) {
            System.out.println("Sanatos");
        } else {
            System.out.println("Bolnav");
        }
    }
}

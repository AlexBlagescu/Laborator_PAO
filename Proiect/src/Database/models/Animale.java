package Database.models;

public class Animale {
    private String nume;
    private long code;
    private String tip;
    private String stareDeSanatate;

    public Animale(String nume, long code, String tip, String stareDeSanatate) {
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

    public String getStareDeSanatate() {
        return stareDeSanatate;
    }

    public void setStareDeSanatate(String stareDeSanatate) {
        this.stareDeSanatate = stareDeSanatate;
    }
}

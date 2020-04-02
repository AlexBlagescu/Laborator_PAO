public class Persoana {
    private String nume;
    private String prenume;
    private int varsta;
    private long CNP;
    private String sex;

    public Persoana(String nume, String prenume, int varsta, long CNP, String sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.CNP = CNP;
        this.sex = sex;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void afisarePersoane() {
        System.out.println();
        System.out.print("Nume: ");
        System.out.println(this.getNume());
        System.out.print("Prenume: ");
        System.out.println(this.getPrenume());
        System.out.print("Varsta: ");
        System.out.println(this.getVarsta());
        System.out.print("Sex: ");
        System.out.println(this.getSex());
        System.out.print("CNP: ");
        System.out.println(this.getCNP());
    }
}

package Database.models;

public class Medic extends Persoana {

    private String orar;
    private long CNPpacient;
    private long CNPpacientAnimale;

    public Medic(String nume, String prenume, int varsta, long CNP, String sex, String orar) {
        super(nume, prenume, varsta, CNP, sex);
        this.orar = orar;
    }

    public Medic(String nume, String prenume, int varsta, long CNP, String sex, String orar, long CNPpacient, long CNPpacientAnimale) {
        super(nume, prenume, varsta, CNP, sex);
        this.orar = orar;
        this.CNPpacient = CNPpacient;
        this.CNPpacientAnimale = CNPpacientAnimale;
    }

    public String getOrar() {
        return orar;
    }

    public void setOrar(String orar) {
        this.orar = orar;
    }

    public long getCNPpacient() {
        return CNPpacient;
    }

    public void setCNPpacient(long CNPpacient) {
        this.CNPpacient = CNPpacient;
    }

    public long getCNPpacientAnimale() {
        return CNPpacientAnimale;
    }

    public void setCNPpacientAnimale(long CNPpacientAnimale) {
        this.CNPpacientAnimale = CNPpacientAnimale;
    }
}

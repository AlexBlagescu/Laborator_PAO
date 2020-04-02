public class Rezidenti extends Persoana {
    private String facultate;
    private long codMedic;

    public Rezidenti(String nume, String prenume, int varsta, long CNP, String sex, String facultate, long codMedic) {
        super(nume, prenume, varsta, CNP, sex);
        this.facultate = facultate;
        this.codMedic = codMedic;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public long getCodMedic() {
        return codMedic;
    }

    public void setCodMedic(long codMedic) {
        this.codMedic = codMedic;
    }
    public void afisareRezidenti() {
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
        System.out.print("Facultate: ");
        System.out.println(this.getFacultate());
        System.out.print("Cod medic unde face practica: ");
        System.out.println(this.getCodMedic());
    }
}

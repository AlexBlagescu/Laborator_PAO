import java.util.ArrayList;
public class Medic extends Persoana {
    private String orar;
    private ArrayList<Pacient> pacienti;
    private ArrayList<Animale> pacientiAnimale;

    public Medic(String nume, String prenume, int varsta, long CNP, String sex, String orar) {
        super(nume, prenume, varsta, CNP, sex);
        this.orar = orar;
        this.pacienti = new ArrayList<Pacient>(0);
        this.pacientiAnimale = new ArrayList<Animale>(0);
    }

    public Medic(String nume, String prenume, int varsta, long CNP, String sex, String orar, ArrayList<Pacient> pacienti, ArrayList<Animale> pacientiAnimale) {
        super(nume, prenume, varsta, CNP, sex);
        this.orar = orar;
        this.pacienti = pacienti;
        this.pacientiAnimale = pacientiAnimale;
    }

    public String getOrar() {
        return orar;
    }

    public void setOrar(String orar) {
        this.orar = orar;
    }

    public ArrayList<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(ArrayList<Pacient> pacienti) {
        this.pacienti = pacienti;
    }
    public void addPacientOm(Pacient om) {
        pacienti.add(om);
    }
    public void addPacientAnimal(Animale animal) {
        pacientiAnimale.add(animal);
    }
    public void afisareMedici() {
        super.afisarePersoane();
        System.out.print("Ore lucratoare: ");
        System.out.println(this.getOrar());
        if (pacienti.size() > 0) {
            System.out.println("Pacienti Oameni:");
            for (Pacient pacient: pacienti) {
                pacient.afisarePacienti();
            }
        } else {
            System.out.println("Medicul nu are pacienti oameni!");
        }
        if (pacientiAnimale.size() > 0) {
            System.out.println("Pacienti Animale:");
            for (Animale pacient: pacientiAnimale) {
                pacient.afisarePacienti();
            }
        } else {
            System.out.println("Medicul nu are pacienti animale!");
        }

    }
}

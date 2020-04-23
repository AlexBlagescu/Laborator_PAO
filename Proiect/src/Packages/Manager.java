package Packages;
import java.util.ArrayList;

public class Manager extends Persoana {
    private ArrayList<Integer> propietati;

    public Manager(String nume, String prenume, int varsta, long CNP, String sex, ArrayList<Integer> propietati) {
        super(nume, prenume, varsta, CNP, sex);
        this.propietati = propietati;
    }
    public Manager(String nume, String prenume, int varsta, long CNP, String sex) {
        super(nume, prenume, varsta, CNP, sex);
        this.propietati = new ArrayList<Integer>(0);
    }

    public ArrayList<Integer> getPropietati() {
        return propietati;
    }

    public void setPropietati(ArrayList<Integer> propietati) {
        this.propietati = propietati;
    }
    public void adaugarePropieati(CabinetMedical ob) {
        this.propietati.add(ob.getCodCabinet());
    }
    public void afisareManager() {
        System.out.println("Manageri: ");
        super.afisarePersoane();
        if (propietati.size() > 0) {
            System.out.print("Cod propietati: ");
            for (Integer i:propietati) {
                System.out.printf("%d ", i);
            }
        } else {
            System.out.println("Managerul nu are propietati!");
        }
    }
}

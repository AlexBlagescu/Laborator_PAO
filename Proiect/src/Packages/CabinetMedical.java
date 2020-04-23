package Packages;

import java.util.ArrayList;

public class CabinetMedical {
    private int numarDeAngajati;
    private String locatie;
    private int codCabinet;
    private ArrayList<Long> codMedici;

    public CabinetMedical(int numarDeAngajati, String locatie, int codCabinet) {
        this.numarDeAngajati = numarDeAngajati;
        this.locatie = locatie;
        this.codCabinet = codCabinet;
        this.codMedici = new ArrayList<Long>(0);
    }
    public CabinetMedical(int numarDeAngajati, String locatie, int codCabinet, ArrayList<Long> codMedici) {
        this.numarDeAngajati = numarDeAngajati;
        this.locatie = locatie;
        this.codCabinet = codCabinet;
        this.codMedici = codMedici;
    }

    public int getNumarDeAngajati() {
        return numarDeAngajati;
    }

    public void setNumarDeAngajati(int numarDeAngajati) {
        this.numarDeAngajati = numarDeAngajati;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public int getCodCabinet() {
        return codCabinet;
    }

    public void setCodCabinet(int codCabinet) {
        this.codCabinet = codCabinet;
    }

    public ArrayList<Long> getCodMedici() {
        return codMedici;
    }

    public void setCodMedici(ArrayList<Long> codMedici) {
        this.codMedici = codMedici;
    }
    public void addMedic(Medic medic) {
        codMedici.add(medic.getCNP());
    }

    public void afisareCabinet() {
        System.out.println();
        System.out.print("Numar de angajati: ");
        System.out.println(getNumarDeAngajati());
        System.out.print("Locatie: ");
        System.out.println(getLocatie());
        System.out.print("Cod cabinet: ");
        System.out.println(getCodCabinet());
        if (getCodMedici().size() > 0) {
            System.out.print("Cod Medici: ");
            for (Long ob:getCodMedici()) {
                System.out.printf("%d ", ob);
            }
        } else {
            System.out.println("Cabinetul medical nu are personal!");
        }
    }
}

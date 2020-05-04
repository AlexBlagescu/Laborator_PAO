package Packages;

import java.util.ArrayList;

public class CsvDisplay {
    private static CsvDisplay ob = null;
    private CsvDisplay() {}

    public static CsvDisplay getInstance()
    {
        if (ob == null)
            ob = new CsvDisplay();
        return ob;
    }

    public void displayPacientiOameni(ArrayList<Pacient> pacientiOameni, ArrayList<Reteta> reteta) {
        if (pacientiOameni.size() > 0) {
            System.out.println("Pacienti: ");
            for (Pacient pacient : pacientiOameni) {
                pacient.afisarePacienti();
                if (pacient.getCodR() == 0) {
                    System.out.println("Pacientul nu are reteta!");
                } else {
                    for (Reteta r : reteta) {
                        if (pacient.getCodR() == r.getCodReteta()) {
                            r.afisareRetata();
                        }
                    }
                }
            }
        } else {
            System.out.println("Nu exsita pacienti!");
        }
    }

    public void displayPacientOmCNP(ArrayList<Pacient> pacientiOameni, ArrayList<Reteta> reteta, long CNP) {
        System.out.println("Pacient: ");
        for (Pacient pacient : pacientiOameni) {
            if (pacient.getCNP() == CNP) {
                pacient.afisarePacienti();
                if (pacient.getCodR() == 0) {
                    System.out.println("Pacientul nu are reteta!");
                } else {
                    for (Reteta r: reteta) {
                        if (pacient.getCodR() == r.getCodReteta()) {
                            r.afisareRetata();
                        }
                    }
                }
            }
        }
    }
    public void displayPacientiAnimale(ArrayList<Animale> pacientiAnimale) {
        System.out.println("Pacienti Animale: ");
        if (pacientiAnimale.size() > 0) {
            for (Animale animale : pacientiAnimale) {
                animale.afisarePacienti();
            }
        } else {
            System.out.println("Nu exista pacienti animle!");
        }
    }
    public void displayPacientAnimaleCOD(ArrayList<Animale> pacientiAnimale, long code) {
        System.out.println("Pacient Animal: ");
        for (Animale obiect : pacientiAnimale) {
            if (obiect.getCode() == code) {
                obiect.afisarePacienti();
            }
        }
    }
    public void displayMedici(ArrayList<Medic> medici) {
        System.out.println("Afisare medici:");
        if (medici.size() > 0) {
            for (Medic medic : medici) {
                medic.afisareMedici();
            }
        } else {
            System.out.println("Nu exista medici");
        }
    }
    public void displayRetete(ArrayList<Reteta> reteta) {
        System.out.println("Retete:\n");
        if (reteta.size() > 0) {
            for (Reteta r : reteta) {
                r.afisareRetata();
            }
        } else {
            System.out.println("Nu exista retete disponibile");
        }
    }
}

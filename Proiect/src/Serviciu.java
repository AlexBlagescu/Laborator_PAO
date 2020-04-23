import Packages.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Serviciu {
    private ArrayList<Pacient> pacientiOameni;
    private ArrayList<Animale> pacientiAnimale;
    private ArrayList<Medic> medici;
    private ArrayList<Reteta> reteta;
    private ArrayList<Manager> manageri;
    private Set<CabinetMedical> cabineteMedicale;
    private Set<Rezidenti> rezidenti;

    public Serviciu() {
        this.pacientiOameni = new ArrayList<Pacient>();
        this.pacientiAnimale = new ArrayList<Animale>();
        this.medici = new ArrayList<Medic>();
        this.cabineteMedicale = new HashSet<CabinetMedical>();
        this.rezidenti = new HashSet<Rezidenti>();
        this.manageri = new ArrayList<Manager>();
        this.reteta = new ArrayList<Reteta>();
    }
    public void addPacientOm(String nume, String prenume, int varsta, long CNP, String sex, boolean stareDeSanatate ,int codR) {
        Pacient p = new Pacient(nume, prenume, varsta, CNP, sex, stareDeSanatate, codR);
        pacientiOameni.add(p);
    }
    public void afisarePacientiOameni() {
        if (pacientiOameni.size() > 0) {
            System.out.println("Pacienti: ");
            for (Pacient pacient : pacientiOameni) {
                pacient.afisarePacienti();
                if (pacient.getCodR() == 0) {
                    System.out.println("Pacientul nu are reteta!");
                } else {
                    for (Reteta reteta : reteta) {
                        if (pacient.getCodR() == reteta.getCodReteta()) {
                            reteta.afisareRetata();
                        }
                    }
                }
            }
        } else {
            System.out.println("Nu exsita pacienti!");
        }
    }

    public void afisarePacientiCNP(long CNP){
        System.out.println("Pacient: ");
        for (Pacient pacient : pacientiOameni) {
            if (pacient.getCNP() == CNP) {
                pacient.afisarePacienti();
                if (pacient.getCodR() == 0) {
                    System.out.println("Pacientul nu are reteta!");
                } else {
                    for (Reteta reteta: reteta) {
                        if (pacient.getCodR() == reteta.getCodReteta()) {
                            reteta.afisareRetata();
                        }
                    }
                }
            }
        }
    }
    public void removePacientOmCNP(long CNP) {
        int poz = -1;
        for (int i = 0; i < pacientiOameni.size(); i++)
            if (pacientiOameni.get(i).getCNP() == CNP) {
                poz = i;
            }
        if (poz == -1) {
            System.out.println("Nu exista respectivul pacient!");
        } else {
            pacientiOameni.remove(pacientiOameni.get(poz));
        }
    }
    public void addPacientAnimal(String nume, long code, String tip, boolean stareDeSanatate) {
        Animale p = new Animale(nume, code, tip, stareDeSanatate);
        pacientiAnimale.add(p);
    }
    public void afisarePacientiAnimale() {
        System.out.println("Pacienti Animale: ");
        if (pacientiAnimale.size() > 0) {
            for (Animale animale : pacientiAnimale) {
                animale.afisarePacienti();
            }
        } else {
            System.out.println("Nu exista pacienti animle!");
        }
    }
    public void afisareAnimaleCOD(long code) {
        System.out.println("Pacient Animal: ");
        for (Animale obiect : pacientiAnimale) {
            if (obiect.getCode() == code) {
                obiect.afisarePacienti();
            }
        }
    }
    public void removePacientAnimalCNP(long code) {
        int poz = -1;
        for (int i = 0; i < pacientiAnimale.size(); i++)
            if (pacientiAnimale.get(i).getCode() == code) {
                poz = i;
            }
        if (poz == -1) {
            System.out.println("Nu exista pacientul respectiv!");
        } else {
            pacientiAnimale.remove(pacientiAnimale.get(poz));
        }
    }
    public void addMedic(String nume, String prenume, int varsta, long CNP, String sex, String orar) {
        Medic p = new Medic(nume, prenume, varsta, CNP, sex, orar);
        medici.add(p);
    }
    public void afisareMedici() {
        System.out.println("Afisare medici:");
        if (medici.size() > 0) {
            for (Medic medic : medici) {
                medic.afisareMedici();
            }
        } else {
            System.out.println("Nu exista medici");
        }
    }
    public void removeMedicCNP(long code) {
        int position = 0;
        for (int i = 0; i < medici.size(); i++) {
            if (medici.get(i).getCNP() == code) {
                position = i;
            }
        }
        medici.remove(medici.get(position));
    }
    public void addPacientOmMedic(long CNPmedic, long CNPPacient) {
        Medic p = null;
        for (Medic medic: medici) {
            if (medic.getCNP() == CNPmedic) {
                p = medic;
            }
        }
        if (p == null) {
            System.out.println("Nu am gasit medicul!");
        } else {
            boolean ok = false;
            for (Pacient pacient: pacientiOameni) {
                if (pacient.getCNP() == CNPPacient) {
                    p.addPacientOm(pacient);
                    ok = true;
                }
            }
            if (!ok) {
                System.out.println("Nu am gasit pacientul om!");
            }
        }
    }
    public void addPacientAnimalMedic(long CNPmedic, long code) {
        Medic p = null;
        for (Medic medic: medici) {
            if (medic.getCNP() == CNPmedic) {
                p = medic;
            }
        }
        if (p == null) {
            System.out.println("Nu am gasit medicul!");
        } else {
            boolean ok = false;
            for (Animale pacient: pacientiAnimale) {
                if (pacient.getCode() == code) {
                    p.addPacientAnimal(pacient);
                    ok = true;
                }
            }
            if (!ok) {
                System.out.println("Nu am gasit pacientul animal!");
            }
        }
    }
    public void addRezident(String nume, String prenume, int varsta, long CNP, String sex, String facultate, long codMedic) {
        Rezidenti p = new Rezidenti(nume, prenume, varsta, CNP, sex, facultate, codMedic);
        rezidenti.add(p);
    }
    public void afisRezidenti() {
        System.out.println("Rezidenti: ");
        if (rezidenti.size() > 0) {
            Iterator<Rezidenti> it = rezidenti.iterator();
            while (it.hasNext()) {
                it.next().afisareRezidenti();
            }
        } else {
            System.out.println("Nu exista rezidenti!");
        }
    }
    public void addReteta(int codReteta, HashSet<String> medicamente) {
        Reteta p = new Reteta(medicamente, codReteta);
        reteta.add(p);
    }
    public void afisareRetete() {
        if (reteta.size() > 0) {
            for (Reteta reteta : reteta) {
                reteta.afisareRetata();
            }
        } else {
            System.out.println("Nu exista retete disponibile");
        }
    }
    public void addRetetaPacient(long CNP, int codReteta) {
        boolean ok = false, ok1 = false;
        for (Reteta value : reteta) {
            if (value.getCodReteta() == codReteta) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            System.out.println("Nu exista reteta cu codul respectiv!");
        } else {
            for (Pacient pacient : pacientiOameni) {
                if (pacient.getCNP() == CNP) {
                    pacient.setCodR(codReteta);
                    ok1 = true;
                }
            }
            if (!ok1) {
                System.out.println("Nu exista pacientul cu CNP-ul respectiv");
            }
        }
    }
    public void adaugareManager(String nume, String prenume, int varsta, long CNP, String sex) {
        Manager m = new Manager(nume, prenume, varsta, CNP, sex);
        manageri.add(m);
    }
    public void afisareManager() {
        if (manageri.size() > 0) {
            for (Manager ob:manageri) {
                ob.afisareManager();
            }
        } else {
            System.out.println("Nu exista manageri!");
        }
    }
    public void addCabinetMedical(int numarDeAngajati, String locatie, int codCabinet) {
        CabinetMedical ob = new CabinetMedical(numarDeAngajati, locatie, codCabinet);
        cabineteMedicale.add(ob);
    }
    public void afisCabineteMedicale() {
        System.out.println("Cabinete Medicale: ");
        if (cabineteMedicale.size() > 0) {
            for (CabinetMedical cabinet : cabineteMedicale) {
                cabinet.afisareCabinet();
            }
        } else {
            System.out.println("Nu exista cabinete medicale!");
        }
    }
    public void asignarePropietateManager(int codPropietate, long CNP) {
        Manager p = null;
        for (Manager manager: manageri) {
            if (manager.getCNP() == CNP) {
                p = manager;
            }
        }
        if (p == null) {
            System.out.println("Nu am gasit managerul!");
        } else {
            boolean ok = false;
            for (CabinetMedical cabinet: cabineteMedicale) {
                if (cabinet.getCodCabinet() == codPropietate) {
                    p.adaugarePropieati(cabinet);
                    ok = true;
                }
            }
            if (!ok) {
                System.out.println("Nu am gasit cabinetul medical!");
            }
        }
    }
    public void asignareMedicCabinet(int codCabinet, long CNP) {
        CabinetMedical p = null;
        for (CabinetMedical cabinet: cabineteMedicale) {
            if (cabinet.getCodCabinet() == codCabinet) {
                p = cabinet;
            }
        }
        if (p == null) {
            System.out.println("Nu am gasit cabinetul medical!");
        } else {
            boolean ok = false;
            for (Medic medic: medici) {
                if (medic.getCNP() == CNP) {
                    p.addMedic(medic);
                    ok = true;
                }
            }
            if (!ok) {
                System.out.println("Nu am gasit cabinetul medicul!");
            }
        }
    }
    public void afisare() {
        System.out.println();
        System.out.print("-----------------------------------------------------");
        System.out.println();
    }
}


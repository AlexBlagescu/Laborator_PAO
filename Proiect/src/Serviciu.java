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
    private CsvReader obCitire = null;
    private CsvDisplay obAfisare = null;
    private CsvWriter obScriere = null;

    public Serviciu() {
        this.pacientiOameni = new ArrayList<Pacient>();
        this.pacientiAnimale = new ArrayList<Animale>();
        this.medici = new ArrayList<Medic>();
        this.reteta = new ArrayList<Reteta>();
        this.cabineteMedicale = new HashSet<CabinetMedical>();
        this.rezidenti = new HashSet<Rezidenti>();
        this.manageri = new ArrayList<Manager>();
        this.obCitire = CsvReader.getInstance();
        this.obAfisare = CsvDisplay.getInstance();
        this.obScriere = CsvWriter.getInstance();
    }
    public void citestePacientiOameni() {
        String fisier = "src/Packages/Pacient.csv";
        this.pacientiOameni = obCitire.readPacientiOameni(fisier);
        String actiune = "Read from " + fisier;
        AuditService.writeToCSV(actiune);
    }
    public void addPacientOm(Pacient p) {
        boolean gasit = false;
        for (Pacient pacient : this.pacientiOameni) {
            if (pacient.getCNP() == p.getCNP()) {
                gasit = true;
                break;
            }
        }
        if (gasit) {
            System.out.println("\nERROR:Pacientul exista deja!\n");
        } else {
            String fisier = "src/Packages/Pacient.csv";
            String actiune = "Write in " + fisier;
            obScriere.writePacientOm(fisier, actiune, p);
            AuditService.writeToCSV(actiune);
            this.pacientiOameni.add(p);
        }
    }
    public void afisarePacientiOameni() {
        obAfisare.displayPacientiOameni(pacientiOameni, reteta);
    }

    public void afisarePacientiCNP(long CNP){
        obAfisare.displayPacientOmCNP(pacientiOameni, reteta, CNP);
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
    public void citestePacientiAnimale() {
        String fisier = "src/Packages/Animale.csv";
        this.pacientiAnimale = obCitire.readPacientiAnimale(fisier);
        String actiune = "Read from " + fisier;
        AuditService.writeToCSV(actiune);
    }
    public void addPacientAnimal(Animale a) {
        boolean gasit = false;
        for (Animale animal : this.pacientiAnimale) {
            if (animal.getCode() == a.getCode()) {
                gasit = true;
                break;
            }
        }
        if (gasit) {
            System.out.println("\nERROR:Animalul exista deja!\n");
        } else {
            String fisier = "src/Packages/Animale.csv";
            String actiune = "Write in " + fisier;
            obScriere.writePacientAnimal(fisier, actiune, a);
            AuditService.writeToCSV(actiune);
            this.pacientiAnimale.add(a);
        }
    }
    public void afisarePacientiAnimale() {
        obAfisare.displayPacientiAnimale(pacientiAnimale);

    }
    public void afisareAnimaleCOD(long code) {
        obAfisare.displayPacientAnimaleCOD(pacientiAnimale, code);
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
    public void citesteMedici() {
        String fisier = "src/Packages/Medic.csv";
        this.medici = obCitire.readMedici(fisier);
        String actiune = "Read from " + fisier;
        AuditService.writeToCSV(actiune);
    }
    public void addMedic(Medic m) {
        boolean gasit = false;
        for (Medic medic : this.medici) {
            if (medic.getCNP() == m.getCNP()) {
                gasit = true;
                break;
            }
        }
        if (gasit) {
            System.out.println("\nERROR:Medicul exista deja!\n");
        } else {
            String fisier = "src/Packages/Medic.csv";
            String actiune = "Write in " + fisier;
            obScriere.writeMedic(fisier, actiune, m);
            AuditService.writeToCSV(actiune);
            this.medici.add(m);
        }
    }
    public void afisareMedici() {
        obAfisare.displayMedici(medici);
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
                    p.addPacientOm(pacient.getCNP());
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
            for (Rezidenti value : rezidenti) {
                value.afisareRezidenti();
            }
        } else {
            System.out.println("Nu exista rezidenti!");
        }
    }
    public void citesteRetete() {
        String fisier = "src/Packages/Reteta.csv";
        this.reteta = obCitire.readReteta(fisier);
        String actiune = "Read from " + fisier;
        AuditService.writeToCSV(actiune);
    }
    public void addReteta(Reteta r) {
        boolean gasit = false;
        for (Reteta reteta : this.reteta) {
            if (reteta.getCodReteta() == r.getCodReteta()) {
                gasit = true;
                break;
            }
        }
        if (gasit) {
            System.out.println("\nERROR:Reteta exista deja!\n");
        } else {
            String fisier = "src/Packages/Reteta.csv";
            String actiune = "Write in " + fisier;
            obScriere.writeReteta(fisier, actiune, r);
            AuditService.writeToCSV(actiune);
            this.reteta.add(r);
        }
    }
    public void afisareRetete() {
        obAfisare.displayRetete(reteta);
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
            if (pacientiOameni != null) {
                for (Pacient pacient : pacientiOameni) {
                    if (pacient.getCNP() == CNP) {
                        pacient.setCodR(codReteta);
                        ok1 = true;
                    }
                }
            } else {
                System.out.println("Nu exista pacienti!");
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


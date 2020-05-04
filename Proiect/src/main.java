import Packages.Animale;
import Packages.Medic;
import Packages.Pacient;
import Packages.Reteta;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class main {
    private static String[] args;

    public static void main(String[] args) {
        Serviciu ob = new Serviciu();

        //Citim toate retetele din CSV, le introducem intr-o structura de tip ArrayList si le afisam.
        System.out.println("-Citim toate retele din fisier si le afisam:-\n");
        ob.citesteRetete();
        ob.afisareRetete();

        // Separam output-urile -- O functie folosita pentru a intelge mai bine output-ul in consola
        ob.afisare();

        //Adaugam o noua retata curenta in ArrayList si in CSV, afisam din nou retele -- "ERROR" in caz de respectiva reteta exista deja
        HashSet<String> medicamente = new HashSet<String>();
        medicamente.add("Ibuprofen");
        medicamente.add("Ibusinus");
        Reteta r = new Reteta(medicamente, 12);
        ob.addReteta(r);

        //Afisarea retetelor
        System.out.println("-Retetele dupa adaugarea unei noi retete-");
        ob.afisareRetete();


        // Separam output-urile
        ob.afisare();

        // Citim toti pacienti (Oameni) din CSV
        ob.citestePacientiOameni();

        // Afisare pacienti(Oameni)
        System.out.println("-Afisam toti pacientii-");
        ob.afisarePacientiOameni();

        // Separam output-urile
        ob.afisare();

        //Creem un nou pacient, adaugam pacientul in structura si scriem  in CSV
        Pacient p = new Pacient("Banu", "Iulia", 31, 256581, "Feminin", true, 25);
        ob.addPacientOm(p);

        // Afisare pacienti(Oameni)
        System.out.println("-Afisam toti pacientii dupa adaugarea unui alt pacient-");
        ob.afisarePacientiOameni();

        // Separam output-urile
        ob.afisare();

        // Afisarea unui anumit pacient dupa CNP
        System.out.println("-Afisam doar un anumit pacient dupa CNP-");
        ob.afisarePacientiCNP(231456);

        // Separam output-urile
        ob.afisare();

        // Stergerea unui pacient dupa CNP
        System.out.println("-Stergem un pacient dupa CNP si afisam restul pacientilor ramasi-");
        ob.removePacientOmCNP(123456);
        ob.afisarePacientiOameni();

        // Separam output-urile
        ob.afisare();

        // Citim toti pacientii (Animale) din CSV
        ob.citestePacientiAnimale();

        // Afisarea pacientilor(Animale)
        System.out.println("-Afisam toti pacientii animale-");
        ob.afisarePacientiAnimale();

        // Separam output-urile
        ob.afisare();

        // Adaugam un pacient Animal nou, in structura, in CSV si afisam din nou lista cu toti pacientii Animale
        Animale a = new Animale("Uzi", 999998, "Leu", true);
        ob.addPacientAnimal(a);

        // Afisarea pacientilor(Animale)
        System.out.println("-Afisam toti pacientii animale dupa adaugarea unuia nou-");
        ob.afisarePacientiAnimale();


        // Separam output-urile
        ob.afisare();

        // Afisarea unui pacient(Animal) dupa cod
        System.out.println("-Afisam un anumit pacient animal dupa codul sau unic-");
        ob.afisareAnimaleCOD(555555);

        // Separam output-urile
        ob.afisare();

        // Stergerae unui pacient animal dupa cod
        System.out.println("-Stergem un anumit pacient animal dupa cod si afisam restul pacientilor ramasi-");
        ob.removePacientAnimalCNP(666666);
        ob.afisarePacientiAnimale();

        // Separam output-urile
        ob.afisare();

        //Citirea medicilor din CSV
        ob.citesteMedici();

        // Afisare medici
        System.out.println("-Afisam toti medicii-");
        ob.afisareMedici();

        // Separam output-urile
        ob.afisare();

        //Adaugam un nou medic in structura, in CSV si afisam medicii
        Medic m = new Medic("Botezatu", "Catalin", 25, 232393, "Masculin", "L,M,MI,V");
        ob.addMedic(m);
        System.out.println("-Afisam medicii dupa ce adaugam un alt medic-");
        ob.afisareMedici();

        // Separam output-urile
        ob.afisare();

        //Concedierea unui medic dupa CNP
        System.out.println("-Stergem un medic dupa CNP si afisam lista medicilor ramasi-");
        ob.removeMedicCNP(125678);
        ob.afisareMedici();

        // Separam output-urile
        ob.afisare();

        //Asignam un Medic pentru un pacient(Om) cu ajutorul CNP-urilor
        System.out.println("-Ii intrebuintam unui medic un pacient si afisam lista tuturor medicilor-");
        ob.addPacientOmMedic(199999, 231456);
        ob.afisareMedici();

        // Separam output-urile
        ob.afisare();

        // Asignam un Medic pentru un pacient(Animal) cu ajutorul CNP-ului si al codului unic.
        System.out.println("-Ii intrebuitam unui medic un pacient animal si afisam lista tuturor medicilor-");
        ob.addPacientAnimalMedic(199999, 555555);
        ob.afisareMedici();

        // Separam output-urile
        ob.afisare();

        // Adaugarea unui Rezident

        ob.addRezident("Ciubota", "Vasile", 23, 100000, "Masculin", "CarolDavila", 239999);
        ob.addRezident("Klaus", "David", 24, 100001, "Masculin", "MedicinaTimisoara", 239999);

        // Afisare rezidenti
        System.out.println("-Afisam toti rezidentii-");
        ob.afisRezidenti();

        // Separam output-urile
        ob.afisare();

        //Adaugam reteta unui Pacient
        System.out.println("-Asignam o anumita reteta unui pacient si afisam lista totala cu pacienti-");
        ob.addRetetaPacient(231456, 1);
        ob.afisarePacientiOameni();

        // Separam output-urile
        ob.afisare();

        //Creeam un manager
        ob.adaugareManager("Klint", "Alex", 21 ,1992700, "Masculin");

        //Afisarea managerului
        System.out.println("-Afisam toti managerii-");
        ob.afisareManager();

        // Separam output-urile
        ob.afisare();

        //Creeam un cabinet medical
        ob.addCabinetMedical(1, "Romania", 25);

        //Afisare cabinete medicale
        System.out.println("-Afisam toate cabinetele medicale-");
        ob.afisCabineteMedicale();

        // Separam output-urile
        ob.afisare();

        //Asignarea unei propieatati unui manager
        System.out.println("-Asignam o propietate unui manager si afisam lista cu toti managerii-");
        ob.asignarePropietateManager(25, 1992700);
        ob.afisareManager();

        // Separam output-urile
        ob.afisare();

        //Asignam un medic unui cabinet medical
        System.out.println("-Asignam un medic unui cabinet medical si afisam lista cu toate cabintele medicale-");
        ob.asignareMedicCabinet(25, 199999);
        ob.afisCabineteMedicale();

    }
}

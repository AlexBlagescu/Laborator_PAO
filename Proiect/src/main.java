import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Serviciu ob = new Serviciu();
        // Adaunga pacienti(Oameni)
        ob.addPacientOm("Copos", "Geani", 41, 123456, "Masculin", true, 0);
        ob.addPacientOm("Elena", "Velma", 55, 231456, "Femnini", false, 0);

        // Afisare pacienti(Oameni)
        System.out.println("-Afisam toti pacientii-");
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

        // Adaugarea unui pacient(Animal)

        ob.addPacientAnimal("Grivei", 555555, "Caine", true);
        ob.addPacientAnimal("Rufus", 666666, "Cangur", false);

        // Afisarea pacientilor(Animale)
        System.out.println("-Afisam toti pacientii animale-");
        ob.afisarePacientiAnimale();

        // Separam output-urile
        ob.afisare();

        // Afisarea unui pacient(Animal) dupa cod
        System.out.println("-Afisam un anumit pacient animal dupca codul sau unic-");
        ob.afisareAnimaleCOD(555555);

        // Separam output-urile
        ob.afisare();

        // Stergerae unui pacient animal dupa cod
        System.out.println("-Stergem un anumit pacient animal dupa cod si afisam restul pacientilor ramasi-");
        ob.removePacientAnimalCNP(666666);
        ob.afisarePacientiAnimale();

        // Adaugare medici

        ob.addMedic("Brutus", "Hercule", 35, 125678, "Masculin", "L,M,Mi,J,V");
        ob.addMedic("Marcus", "Aurelius", 25, 199999, "Masculin", "L,M");
        ob.addMedic("Ceausu", "Dorina", 30, 239999, "Feminin", "Mi,J,V");

        // Separam output-urile
        ob.afisare();

        // Afisare medici
        System.out.println("-Afisam toti medicii-");
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

        //Adaugarea unei noi retete
        System.out.println("-Creem o noua reteta si o afisam-");
        HashSet<String> reteta1 = new HashSet<String>(0);
        reteta1.add("Paracetamol");
        reteta1.add("Asipirina");
        ob.addReteta(1, reteta1);

        //Afisarea retetelor curente

        ob.afisareRetete();

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

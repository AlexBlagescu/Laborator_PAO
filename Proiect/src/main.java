import Database.config.SetUpData;
import Database.models.Persoana;
import Database.models.Pacient;
import Database.models.Medic;
import Database.models.Animale;

import Database.repository.RepositoryPacient;
import Database.repository.RepositoryAnimale;
import Database.repository.RepositoryMedic;
import Database.repository.RepositoryPersoana;

public class main {

    public static void main(String[] args) {
        SetUpData setUpData = new SetUpData();

        //Crearea tuturor tabelelor si initializarea servicilor

        setUpData.setUp();
        RepositoryPersoana personRepository = new RepositoryPersoana();
        RepositoryMedic medicRepository = new RepositoryMedic();
        RepositoryAnimale animaleRepository = new RepositoryAnimale();
        RepositoryPacient pacientRepository = new RepositoryPacient();

        //Adaugarea unei persoane noi si afisarea tuturor persoanelor

        setUpData.addPerson("Alex", "Blagescu", 21, 1990123, "Masculin");
        setUpData.displayPersoane();

        // Afisarea unei persoane dupa CNP

        personRepository.displayPersonAfterCNP(1990123);

        // Modificarea numelui unei persoane dupa CNP

        personRepository.updatePersonName("Gigel", 1990123);
        personRepository.displayPersonAfterCNP(1990123);

        // Modificarea prenumelui unei persoane dupa CNP

        personRepository.updatePersonPrename("Gigel", 1990123);
        personRepository.displayPersonAfterCNP(1990123);

        // Modificarea varsta unei persoane dupa CNP

        personRepository.updatePersonAge(15, 1990123);
        personRepository.displayPersonAfterCNP(1990123);

        // Stergerea unei persoane din baza de date dupa CNP si afisarea tuturor persoanelor

        personRepository.deletePersoanaAfterCNP(1990123);
        setUpData.displayPersoane();

        // Adaugarea unui pacient animal si afisarea tuturor pacientilor animale

        setUpData.addAnimal("Grivei", 123123, "Cangur", "Sanatos");
        setUpData.displayAnimale();

        // Afisarea unui animal dupa cod

        animaleRepository.displayAnimalAfterCode(123153);

        // Modifcarea numelui unui animal dupa cod si afisarea animalului dupa Code

        animaleRepository.updateAnimaleNume("Cora", 123123);
        animaleRepository.displayAnimalAfterCode(123123);

        // Modificarea stari de sanatate unui animal dupa cod

        animaleRepository.updateStareDeSanatate("Bolnav", 123123);
        animaleRepository.displayAnimalAfterCode(123123);

        // Stergerea unui animal dupa cod si afisarea tuturor animalelor

        animaleRepository.deleteAnimalAfterCode(123123);
        setUpData.displayAnimale();

        // Adaugarea unui pacient om si afisarea tuturor pacientilor

        setUpData.addPacient("Apetrei", "Codrin", 25, 199001, "Masculin", "Sanatos",-1);
        setUpData.displayPacienti();

        // Afisarea unui pacient om dupa CNP

        pacientRepository.displayPacientAfterCNP(199061);

        // Modificarea numele unui pacient dupa CNP si afisarea lui

        pacientRepository.updatePacientNume("Bota", 199001);
        pacientRepository.displayPacientAfterCNP(199001);

        // Modificarea prenumelui unui pacient dupa CNP si afisarea lui

        pacientRepository.updatePacientPrenume("Silviu", 199001);
        pacientRepository.displayPacientAfterCNP(199001);

        // Modificarea varstei unui pacient dupa CNP si afisarea lui

        pacientRepository.updatePacientVarsta(15, 199001);
        pacientRepository.displayPacientAfterCNP(199001);

        // Modificarea starii de sanatate a unui pacient dupa CNP si afisarea lui

        pacientRepository.updatePacientStareDeSanatate("Partial-Sanatos", 199001);
        pacientRepository.displayPacientAfterCNP(199001);

        // Asigarea unei retete unui pacient si afisarea lui

        pacientRepository.updatePacientCodReteta(1, 199001);
        pacientRepository.displayPacientAfterCNP(199001);

        // Stergerea unui pacient dupa CNP si afisarea tuturor pacientilor

        pacientRepository.deletePacientAfterCNP(199001);
        setUpData.displayPacienti();

        // Adaugarea unui medic si afisarea tuturor medicilor

        setUpData.addMedic("Dorneanu", "Eduard", 30, 199999, "Masculin", "L,M,MI,V", -1, -1);
        setUpData.displayMedici();

        // Afisarea unui medic dupa CNP

        medicRepository.displayMedicAfterCNP(199999);
//
        // Modificarea numelui unui medic dupa CNP si afisarea lui

        medicRepository.updateMedicNume("Bazavan", 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Modificarea prenumelui unui medic dupa CNP si afisarea lui

        medicRepository.updateMedicPrenume("Alex", 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Modificarea varstei unui medic dupa CNP si afisarea lui

        medicRepository.updateMedicVarsta(31, 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Modificarea orarului unui medic dupa CNP si afisarea lui

        medicRepository.updateMedicOrar("L", 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Intrebuintam medicului un pacient animal si afisam medicul dupa CNP

        medicRepository.updateMedicPacientAnimal(123123, 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Intrebuintam medicului un pacient om si afisam medicul dupa CNP

        medicRepository.updateMedicPacientOm(199001, 199999);
        medicRepository.displayMedicAfterCNP(199999);

        // Stergearea unui medic dupa CNP

        medicRepository.deleteMedic(199999);
        medicRepository.displayMedicAfterCNP(199999);
    }
}

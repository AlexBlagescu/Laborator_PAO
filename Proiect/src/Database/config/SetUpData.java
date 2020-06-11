package Database.config;

import Database.repository.RepositoryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetUpData {

    public void setUp() {
        String createTableSqlPersoana = "CREATE TABLE IF NOT EXISTS Persoana" +
                "(nume varchar(30), prenume varchar(30), varsta int, " +
                "CNP bigint PRIMARY KEY AUTO_INCREMENT, sex varchar(30))";

        String createTableSqlAnimale = "CREATE TABLE IF NOT EXISTS Animale" +
                "(nume varchar(30), code bigint PRIMARY KEY AUTO_INCREMENT, " +
                "tip varchar(30), sanatate varchar(30))";

        String createTableSqlPacient = "CREATE TABLE IF NOT EXISTS Pacient" +
                "(nume varchar(30), prenume varchar(30), varsta int, " +
                "CNP bigint PRIMARY KEY AUTO_INCREMENT, sex varchar(30), " +
                "sanatate varchar(30), codReteta int)";

        String createTableSqlMedic = "CREATE TABLE IF NOT EXISTS Medic" +
                "(nume varchar(30), prenume varchar(30), varsta int, " +
                "CNP bigint PRIMARY KEY AUTO_INCREMENT, sex varchar(30), " +
                "orar varchar(30), CNPpacientOm bigint, CNPpacientAnimale bigint)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSqlPersoana);
            repositoryHelper.executeSql(databaseConnection, createTableSqlAnimale);
            repositoryHelper.executeSql(databaseConnection, createTableSqlPacient);
            repositoryHelper.executeSql(databaseConnection, createTableSqlMedic);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(String nume, String prenume, int varsta, long CNP, String sex) {

        String insertPersonSql = String.format("INSERT INTO Persoana(nume, prenume, varsta, CNP, sex) VALUES('%s', '%s', %d, %d, '%s')", nume, prenume, varsta, CNP, sex);

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPacient(String nume, String prenume, int varsta, long CNP, String sex, String sanatate, int codReteta) {

        String insertPacientSql = String.format("INSERT INTO Pacient(nume, prenume, varsta, CNP, sex, sanatate, codReteta) VALUES('%s', '%s', %d, %d, '%s', '%s', %d)", nume, prenume, varsta, CNP, sex, sanatate, codReteta);

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPacientSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMedic(String nume, String prenume, int varsta, long CNP, String sex, String orar, long CNPpacientOm, long CNPpacientAnimal) {

        String insertMedicSql = String.format("INSERT INTO Medic(nume, prenume, varsta, CNP, sex, orar, CNPpacientOm, CNPpacientAnimale) VALUES('%s', '%s', %d, %d, '%s', '%s', %d, %d)", nume, prenume, varsta, CNP, sex, orar, CNPpacientOm, CNPpacientAnimal);

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertMedicSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAnimal(String nume, long code, String tip, String sanatate) {

        String insertPacientSql = String.format("INSERT INTO Animale(nume, code, tip, sanatate) VALUES('%s', %d, '%s', '%s')", nume, code, tip, sanatate);

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPacientSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPersoane() {
        String selectSql = "SELECT * FROM Persoana";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            boolean status = resultSet.next();
            System.out.println("\n--AFISAREA TUTUROR PERSOANELOR--\n");
            if (!status) {
                System.out.println("Nu exista persoane in baza de date!");
            } else {
                while (status) {
                    System.out.println("Nume:" + resultSet.getString(1));
                    System.out.println("Prenume:" + resultSet.getString(2));
                    System.out.println("Varsta:" + resultSet.getInt(3));
                    System.out.println("CNP:" + resultSet.getLong(4));
                    System.out.println("Sex:" + resultSet.getString(5));
                    System.out.println();
                    status = resultSet.next();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMedici() {
        String selectSql = "SELECT * FROM Medic";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            boolean status = resultSet.next();
            System.out.println("\n--AFISAREA TUTUROR MEDICILOR--\n");
            if (!status) {
                System.out.println("Nu exista medici in baza de date!");
            } else {
                while (status) {
                    System.out.println("Nume:" + resultSet.getString(1));
                    System.out.println("Prenume:" + resultSet.getString(2));
                    System.out.println("Varsta:" + resultSet.getInt(3));
                    System.out.println("CNP:" + resultSet.getLong(4));
                    System.out.println("Sex:" + resultSet.getString(5));
                    System.out.println("Orar:" + resultSet.getString(6));
                    if (resultSet.getLong(7) == -1) {
                        System.out.println("Medicul nu are pacient om");
                    } else {
                        System.out.println("Cod pacient om:" + resultSet.getLong(7));
                    }
                    if (resultSet.getLong(8) == -1) {
                        System.out.println("Medicul nu are pacient animal");
                    } else {
                        System.out.println("Cod pacient animal:" + resultSet.getLong(8));
                    }
                    System.out.println();
                    status = resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPacienti() {
        String selectSql = "SELECT * FROM Pacient";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            boolean status = resultSet.next();
            System.out.println("\n--AFISAREA TUTUROR PACIENTILOR--\n");
            if (!status) {
                System.out.println("Nu exista pacienti in baza de date!");
            } else {
                while (status) {
                    System.out.println("Nume:" + resultSet.getString(1));
                    System.out.println("Prenume:" + resultSet.getString(2));
                    System.out.println("Varsta:" + resultSet.getInt(3));
                    System.out.println("CNP:" + resultSet.getLong(4));
                    System.out.println("Sex:" + resultSet.getString(5));
                    System.out.println("Stare de sanatate:" + resultSet.getString(6));
                    if (resultSet.getInt(7) == -1) {
                        System.out.println("Pacientul nu are inca o reteta!");
                    } else {
                        System.out.println("Cod reteta:" + resultSet.getInt(7));
                    }
                    System.out.println();
                    status = resultSet.next();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAnimale() {
        String selectSql = "SELECT * FROM Animale";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            boolean status = resultSet.next();
            System.out.println("\n--AFISAREA TUTUROR ANIMALELOR--\n");
            if (!status) {
                System.out.println("Nu exista animale in baza de date!");
            } else {
                while (status) {
                    System.out.println("Nume:" + resultSet.getString(1));
                    System.out.println("Cod:" + resultSet.getLong(2));
                    System.out.println("Tip animal:" + resultSet.getString(3));
                    System.out.println("Stare de sanatate:" + resultSet.getString(4));
                    System.out.println();
                    status = resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Database.repository;

import java.sql.*;

import Database.config.DatabaseConfiguration;
import Database.models.Pacient;

public class RepositoryPacient {

    public Pacient getPacientByCNP(long CNP) {
        String selectSql = "SELECT * FROM Pacient WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(4, CNP);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToPacient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void displayPacientAfterCNP(long CNP) {
        String selectSql = "SELECT * FROM Pacient WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, CNP);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n--AFISAREA UNUI PACIENT DUPA CNP--\n");
            boolean status = resultSet.next();
            if (status) {
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
            } else {
                System.out.println("Error: Nu exista pacientul cu CNP-ul respectiv");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePacientNume(String nume, long CNP) {
        String updateNameSql = "UPDATE Pacient SET nume=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePacientPrenume(String prenume, long CNP) {
        String updateNameSql = "UPDATE Pacient SET prenume=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, prenume);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePacientVarsta(int varsta, long CNP) {
        String updateNameSql = "UPDATE Pacient SET varsta=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, varsta);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePacientStareDeSanatate(String stare, long CNP) {
        String updateNameSql = "UPDATE Pacient SET sanatate=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, stare);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePacientCodReteta(int cod, long CNP) {
        String updateNameSql = "UPDATE Pacient SET codReteta=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, cod);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePacientAfterCNP(long CNP) {
        String updateNameSql = "DELETE FROM Pacient WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Pacient mapToPacient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Pacient(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4) ,resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
        }
        return null;
    }
}


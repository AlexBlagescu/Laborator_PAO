package Database.repository;

import java.sql.*;

import Database.config.DatabaseConfiguration;
import Database.models.Animale;

public class RepositoryAnimale {

    public Animale getAnimalByCode(long code) {
        String selectSql = "SELECT * FROM Animale WHERE code=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(2, code);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAnimale(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void displayAnimalAfterCode(long code) {
        String selectSql = "SELECT * FROM Animale WHERE code=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean status= resultSet.next();
            System.out.println("\n--AFISAREA UNUI ANIMAL PACIENT DUPA CNP--\n");

            if (status) {
                System.out.println("Nume:" + resultSet.getString(1));
                System.out.println("Cod:" + resultSet.getLong(2));
                System.out.println("Tip animal:" + resultSet.getString(3));
                System.out.println("Stare de sanatate:" + resultSet.getString(4));
            } else {
                System.out.println("Error: Nu exista animalul cu codul respectiv!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnimaleNume(String nume, long code) {
        String updateNameSql = "UPDATE Animale SET nume=? WHERE code=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setLong(2, code);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStareDeSanatate(String sanatate, long code) {
        String updateNameSql = "UPDATE Animale SET sanatate=? WHERE code=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, sanatate);
            preparedStatement.setLong(2, code);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnimalAfterCode(long code) {
        String updateNameSql = "DELETE FROM Animale WHERE code=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Animale mapToAnimale(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Animale(resultSet.getString(1), resultSet.getLong(2), resultSet.getString(3), resultSet.getString(4));
        }
        return null;
    }
}

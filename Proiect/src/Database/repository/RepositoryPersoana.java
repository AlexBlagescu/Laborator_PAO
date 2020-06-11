package Database.repository;

import java.sql.*;

import Database.config.DatabaseConfiguration;
import Database.models.Persoana;

public class RepositoryPersoana {

    public Persoana getPersonByCNP(long CNP) {
        String selectSql = "SELECT * FROM Persoana WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, CNP);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToPerson(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void displayPersonAfterCNP(long CNP) {
        String selectSql = "SELECT * FROM Persoana WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, CNP);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n--AFISAREA UNEI PERSOANE DUPA CNP--\n");
            boolean status = resultSet.next();
            if (status) {
                System.out.println("Nume:" + resultSet.getString(1));
                System.out.println("Prenume:" + resultSet.getString(2));
                System.out.println("Varsta:" + resultSet.getInt(3));
                System.out.println("CNP:" + resultSet.getLong(4));
                System.out.println("Sex:" + resultSet.getString(5));
            } else {
                System.out.println("Error: Nu exista persoana cu CNP-ul respectiv");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePersonName(String name, long CNP) {
        String updateNameSql = "UPDATE Persoana SET nume=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePersonPrename(String prename, long CNP) {
        String updateNameSql = "UPDATE Persoana SET prenume=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, prename);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePersonAge(int varsta, long CNP) {
        String updateNameSql = "UPDATE Persoana SET varsta=? WHERE CNP=?";

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

    public void deletePersoanaAfterCNP(long CNP) {
        String updateNameSql = "DELETE FROM Persoana WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, CNP);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Persoana mapToPerson(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Persoana(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4), resultSet.getString(3));
        }
        return null;
    }
}

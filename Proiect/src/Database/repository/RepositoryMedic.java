package Database.repository;

import java.sql.*;

import Database.config.DatabaseConfiguration;
import Database.models.Medic;

public class RepositoryMedic {

    public Medic getMedicByCNP(long CNP) {
        String selectSql = "SELECT * FROM Medic WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, CNP);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMedic(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayMedicAfterCNP(long CNP) {
        String selectSql = "SELECT * FROM Medic WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setLong(1, CNP);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\n--AFISAREA UNUI MEDIC DUPA CNP--\n");
            boolean status = resultSet.next();
            if (status) {
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
            } else {
                System.out.println("Error: Nu exista medicul cu CNP-ul respectiv");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMedicNume(String nume, long CNP) {
        String updateNameSql = "UPDATE Medic SET nume=? WHERE CNP=?";

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

    public void updateMedicPrenume(String prenume, long CNP) {
        String updateNameSql = "UPDATE Medic SET prenume=? WHERE CNP=?";

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

    public void updateMedicVarsta(int varsta, long CNP) {
        String updateNameSql = "UPDATE Medic SET varsta=? WHERE CNP=?";

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

    public void updateMedicOrar(String orar, long CNP) {
        String updateNameSql = "UPDATE Medic SET orar=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, orar);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMedicPacientAnimal(long code, long CNP) {
        String updateNameSql = "UPDATE Medic SET CNPpacientAnimale=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, code);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMedicPacientOm(long CNPpacient, long CNP) {
        String updateNameSql = "UPDATE Medic SET CNPpacientOm=? WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, CNPpacient);
            preparedStatement.setLong(2, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedic(long CNP) {
        String updateNameSql = "DELETE FROM Medic WHERE CNP=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setLong(1, CNP);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Medic mapToMedic(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Medic(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4) ,resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8));
        }
        return null;
    }
}


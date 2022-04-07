package com.team4.service.wallet;

import com.team4.config.SingletonConnection;
import com.team4.model.Wallet;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletService implements IWalletService {
    private static final String SELECT_ALL_WALLET = "select id_wallet, name_wallet, current_amount, description from wallet";
    private static final String INSERT_USERS_SQL = "insert into wallet(name_wallet,current_amount, description) values (?,?,?)";
    private static final String SELECT_WALLET_BY_ID = "select name_wallet, current_amount, description from wallet " +
            "where id_wallet = ?;";
    private static final String UPDATE_USERS_SQL = "update wallet set name_wallet = ?, current_amount = ?, " +
            "description = ? where id_wallet = ?;";

//    public static void main(String[] args) {
//        WalletService walletService = new WalletService();
//        System.out.println(walletService.getById(1));
//    }

    @Override
    public List<Wallet> selectAll() {
        List<Wallet> wallets = new ArrayList<>();
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WALLET);
        ) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_wallet");
                String name = resultSet.getString("name_wallet");
                double currency = resultSet.getDouble("current_amount");
                String description = resultSet.getString("description");
                wallets.add(new Wallet(id, name, currency, description));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets;
    }

    @Override
    public void insert(Wallet wallet) {
        System.out.println(INSERT_USERS_SQL);
        //  try-with-resource statement will auto close the connection
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, wallet.getName_wallet()); // Đối tượng thuộc interface gọi phương thức setString
            preparedStatement.setDouble(2, wallet.getBalance());
            preparedStatement.setString(3, wallet.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e); // Method in ra SQLException tuỳ từng trường hợp
        }
    }

    @Override
    public Wallet getById(int id) {
        Wallet wallet = null;
        //  Step 1: Establishing a Connection
        try (Connection connection = SingletonConnection.getConnect();
             //  Step 2: Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WALLET_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            //  Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            //  Step 4: Process the ResultSet Object
            while (rs.next()) {
                String name = rs.getString("name_wallet");
                double balance = rs.getDouble("current_amount");
                String description = rs.getString("description");
                wallet = new Wallet(id, name, balance, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return wallet;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Wallet wallet) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, wallet.getName_wallet());
            preparedStatement.setDouble(2, wallet.getBalance());
            preparedStatement.setString(3, wallet.getDescription());
            preparedStatement.setInt(4, wallet.getId_wallet());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

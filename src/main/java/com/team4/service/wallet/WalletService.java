package com.team4.service.wallet;

import com.team4.config.SingletonConnection;
import com.team4.model.CurrencyWallet;
import com.team4.model.User;
import com.team4.model.Wallet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletService implements IWalletService {
<<<<<<< HEAD
    private static final String SELECT_ALL_WALLET = "select id_wallet, name_wallet, current_amount, description from wallet";
    private static final String INSERT_WALLET_SQL = "insert into wallet(name_wallet, id_currency, id_user," +
            "current_amount, description) values (?,?,?,?,?)";
    private static final String SELECT_WALLET_BY_ID = "select name_wallet, current_amount, description from wallet " +
            "where id_wallet = ?;";
    private static final String UPDATE_USERS_SQL = "update wallet set name_wallet = ?, current_amount = ?, " +
            "description = ? where id_wallet = ?;";

//    public static void main(String[] args) {
//        WalletService walletService = new WalletService();
//        System.out.println(walletService.getById(1));
//    }
=======
    Connection connection = SingletonConnection.getConnect();
>>>>>>> duong

    @Override
    public List<Wallet> selectAll() {
        List<Wallet> wallets = new ArrayList<>();
        String query = "{CALL selectAllWallet()}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_wallet");
                String name = resultSet.getString("name_wallet");
                double currentAmount = resultSet.getDouble("current_amount");
                String description = resultSet.getString("description");
                int id_cur = resultSet.getInt("id_currency");
                String name_cur = resultSet.getString("name_currency");
                int id_user = resultSet.getInt("id_user");
                String name_user = resultSet.getString("name_user");
                CurrencyWallet currencyWallet = new CurrencyWallet(id_cur, name_cur);
                User user = new User(id_user, name_user);
                Wallet wallet = new Wallet(id, name, currentAmount, description, user, currencyWallet);
                wallets.add(wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets;
    }

    @Override
    public void insert(Wallet wallet) {
<<<<<<< HEAD
        System.out.println(INSERT_WALLET_SQL);
        //  try-with-resource statement will auto close the connection
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WALLET_SQL)) {
            preparedStatement.setString(1, wallet.getName_wallet());
            preparedStatement.setInt(2, wallet.getCurrencyWallet().getId());
            preparedStatement.setInt(3, wallet.getUserWallet().getId());
            preparedStatement.setDouble(4, wallet.getBalance());
            preparedStatement.setString(5, wallet.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
=======
        String query = "{CALL insertNewWallet(?,?,?,?,?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, wallet.getName());
            callableStatement.setInt(2, wallet.getCurrencyWallet().getId());
            callableStatement.setInt(3, wallet.getUser().getId());
            callableStatement.setDouble(4, wallet.getBalance());
            callableStatement.setString(5, wallet.getDescription());
            callableStatement.executeUpdate();
>>>>>>> duong
        } catch (SQLException e) {
            e.printStackTrace();
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
}

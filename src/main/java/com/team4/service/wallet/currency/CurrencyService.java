package com.team4.service.wallet.currency;

import com.team4.config.SingletonConnection;
import com.team4.model.CurrencyWallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyService implements ICurrencyService {
    private static final String SELECT_ALL_CURRENCY = "select id_currency, name_currency from currency;";
//    private static final String INSERT_CURRENCY_WALLET_SQL = "insert into wallet(id_currency) values (?);";

//    public static void main(String[] args) {
//        CurrencyService c = new CurrencyService();
//        System.out.println(c.selectAll());
//    }

    @Override

    public List<CurrencyWallet> selectAll() {
        List<CurrencyWallet> currencyWallets = new ArrayList<>();
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CURRENCY);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_currency");
                String name = resultSet.getString("name_currency");
                currencyWallets.add(new CurrencyWallet(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencyWallets;
    }

    @Override
    public void insert(CurrencyWallet currencyWallet) {
//        System.out.println(INSERT_CURRENCY_WALLET_SQL);
//        //  try-with-resource statement will auto close the connection
//        try (Connection connection = SingletonConnection.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CURRENCY_WALLET_SQL)) {
//            preparedStatement.setInt(1, currencyWallet.getId()); // Đối tượng thuộc interface gọi phương thức
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e); // Method in ra SQLException tuỳ từng trường hợp
//        }
    }

    @Override
    public CurrencyWallet getById(int id) {
        CurrencyWallet currencyWallet = null;
        try (
                Connection c = SingletonConnection.getConnect();
                PreparedStatement preparedStatement = c.prepareStatement("SELECT  * FROM  currency where  id_currency=?")
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_currency");
                currencyWallet = new CurrencyWallet(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencyWallet;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(CurrencyWallet currencyWallet) throws SQLException {
        return false;
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

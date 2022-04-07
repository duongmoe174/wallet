package com.team4.service.wallet.users;

import com.team4.config.SingletonConnection;
import com.team4.model.CurrencyWallet;
import com.team4.model.UserWallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserWalletService implements IUserWalletService {
    private static final String SELECT_ALL_USER = "select id_user, name_user from user;";

    @Override
    public List<UserWallet> selectAll() {
        List<UserWallet> userWallets = new ArrayList<>();
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String name = resultSet.getString("name_user");
                userWallets.add(new UserWallet(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userWallets;
    }

    @Override
    public void insert(UserWallet userWallet) {

    }

    @Override
    public UserWallet getById(int id) {
        UserWallet userWallet = null;
        try (
                Connection c = SingletonConnection.getConnect();
                PreparedStatement preparedStatement = c.prepareStatement("SELECT  * FROM  user where  id_user=?")
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_user");
                userWallet = new UserWallet(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userWallet;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserWallet userWallet) throws SQLException {
        return false;
    }
}

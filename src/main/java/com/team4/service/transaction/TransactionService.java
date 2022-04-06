package com.team4.service.transaction;

import com.team4.config.SingletonConnection;
import com.team4.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.team4.config.SingletonConnection.getConnect;

public class TransactionService implements ITransactionService{
    Connection connection = SingletonConnection.getConnect();

    public TransactionService() {
    }

    @Override
    public List<Transaction> selectAll() {
        List<Transaction> transactionList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction;");){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_transaction");
                String name = resultSet.getString("name_transaction");
                transactionList.add(new Transaction(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }

    @Override
    public void insert(Transaction transaction) {

    }

    @Override
    public Transaction getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Transaction transaction) throws SQLException {
        return false;
    }
}

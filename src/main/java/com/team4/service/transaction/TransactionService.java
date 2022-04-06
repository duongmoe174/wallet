package com.team4.service.transaction;

import com.team4.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TransactionService implements ITransactionService{
    @Override
    public List<Transaction> selectAll() {
        return null;
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

package com.team4.service.transaction;

import com.team4.model.TransactionDetail;

import java.sql.SQLException;
import java.util.List;

public class TransactionDetailService implements ITransactionDetailService{
    @Override
    public List<TransactionDetail> selectAll() {
        return null;
    }

    @Override
    public void insert(TransactionDetail transactionDetail) {

    }

    @Override
    public TransactionDetail getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TransactionDetail transactionDetail) throws SQLException {
        return false;
    }
}

package com.example.demo.services;

import com.example.demo.model.Transactions;
import com.example.demo.model.Users;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transactions> getALLTrans();
    void deleteTransaction(Long id);
    Transactions updateTransaction(Transactions transactions, Long id);
    Optional<Transactions> findTransactionById(Long id);
    Transactions insertTran(Transactions transactions);
}

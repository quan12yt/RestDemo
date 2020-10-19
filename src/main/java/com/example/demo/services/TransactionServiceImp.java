package com.example.demo.services;

import com.example.demo.exception.TransactionNotFoundException;
import com.example.demo.model.Transactions;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImp implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transactions> getALLTrans() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public Transactions updateTransaction(Transactions transactions, Long id) {
        return transactionRepository.findById(id).map(trans -> {
            trans.setAmount(transactions.getAmount());
            trans.setBank(transactions.getBank());
            trans.setTransactionType(transactions.getTransactionType());
            return transactionRepository.save(transactions);
        }).orElseGet(() -> {
            return transactionRepository.save(transactions);
        });
    }

    @Override
    public Optional<Transactions> findTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transactions insertTran(Transactions transactions) {
        return  transactionRepository.save(transactions);
    }
}

package com.example.demo.controller;

import com.example.demo.model.Transactions;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.exception.TransactionNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/transactions")
public class TransactionsController{
    private final TransactionRepository transactionRepository;

    public TransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("")
    public List<Transactions> getTransactions(){
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transactions getOneT(@PathVariable Long id){
        return transactionRepository.findById(id).orElseThrow(() ->
                {
                    return new TransactionNotFoundException(id);
                }
                );
    }

    @PostMapping("")
    public Transactions postTran(@RequestBody Transactions transactions){
        return  transactionRepository.save(transactions);
    }

    @PutMapping("/{id}")
    public Transactions putTran(@RequestBody Transactions tran,@PathVariable Long id){
        return transactionRepository.findById(id).map(transactions -> {
            transactions.setAmount(tran.getAmount());
            transactions.setBank(tran.getBank());
            transactions.setTransactionType(tran.getTransactionType());
            return transactionRepository.save(transactions);
        }).orElseGet(() -> {
            return transactionRepository.save(tran);
        });
    }
    @DeleteMapping("/{id}")
    public void deleteTran(@PathVariable Long id){
        transactionRepository.deleteById(id);
    }
}
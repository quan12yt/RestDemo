package com.example.demo.controller;

import com.example.demo.model.Transactions;
import com.example.demo.exception.TransactionNotFoundException;
import com.example.demo.services.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/transactions")
public class TransactionsController{
    @Autowired
    private final TransactionServiceImp transactionServiceImp;

    public TransactionsController(TransactionServiceImp transactionServiceImp){
        this.transactionServiceImp = transactionServiceImp;
    }
    //get list of transactions
    @GetMapping("")
    public List<Transactions> getTransactions(){
        return transactionServiceImp.getALLTrans();
    }
    //get a transaction by its id
    @GetMapping("/{id}")
    public Optional<Transactions> getOneT(@PathVariable Long id){
        return transactionServiceImp.findTransactionById(id);
    }
    //create a new transaction
    @PostMapping("")
    public Transactions postTran(@RequestBody Transactions transactions){
        return  transactionServiceImp.insertTran(transactions);
    }
    //Update existed transaction or new one if not existed
    @PutMapping("/{id}")
    public Transactions putTran(@RequestBody Transactions tran,@PathVariable Long id){
        return transactionServiceImp.updateTransaction(tran,id);
    }
    //remove a transaction by its id
    @DeleteMapping("/{id}")
    public void deleteTran(@PathVariable Long id){
        transactionServiceImp.deleteTransaction(id);
    }
}
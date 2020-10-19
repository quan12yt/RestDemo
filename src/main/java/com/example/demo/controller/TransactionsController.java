package com.example.demo.controller;

import com.example.demo.model.Transactions;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.security.TransactionNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/transactions")
public class TransactionsController{
    private final TransactionRepository transactionRepository;

    public TransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/transactions")
    public List<Transactions> getTransactions(){
        return transactionRepository.findAll();
    }

    @GetMapping("api/transactions/{id}")
    public Transactions getOneT(@PathVariable int id){
        return transactionRepository.findById(id).orElseThrow(() ->
                {
                    return new TransactionNotFoundException(id);
                }
                );
    }

    @PostMapping("api/transactions")
    @ResponseBody
    public Transactions postTran(@RequestBody Transactions transactions){
        return  transactionRepository.save(transactions);
    }

    @PutMapping("api/transactions/{id}")
    @ResponseBody
    public Transactions putTran(@RequestBody Transactions tran,@PathVariable int id){
        return transactionRepository.findById(id).map(transactions -> {
            transactions.setAmount(tran.getAmount());
            transactions.setBank(tran.getBank());
            transactions.setTransaction_type(tran.getTransaction_type());
            return transactionRepository.save(transactions);
        }).orElseGet(() -> {
            return transactionRepository.save(tran);
        });
    }
    @DeleteMapping("api/transactions/{id}")
    public void deleteTran(@PathVariable int id){
        transactionRepository.deleteById(id);
    }
}
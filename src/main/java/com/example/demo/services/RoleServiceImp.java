package com.example.demo.services;

import com.example.demo.model.Roles;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Roles> getALLRoles() {
        return roleRepository.findAll();
    }
//
//    @Override
//    public void deleteTransaction(Long id) {
//        transactionRepository.deleteById(id);
//    }
//
//    @Override
//    public Transactions updateTransaction(Transactions transactions, Long id) {
//        return transactionRepository.findById(id).map(trans -> {
//            trans.setAmount(transactions.getAmount());
//            trans.setBank(transactions.getBank());
//            trans.setTransactionType(transactions.getTransactionType());
//            return transactionRepository.save(trans);
//        }).orElseGet(() -> transactionRepository.save(transactions));
//    }
//
//    @Override
//    public Optional<Transactions> findTransactionById(Long id) {
//        return transactionRepository.findById(id);
//    }
//
//    @Override
//    public Transactions insertTran(Transactions transactions) {
//        return  transactionRepository.save(transactions);
//    }
}

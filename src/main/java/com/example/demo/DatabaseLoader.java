//package com.example.demo;
//
//import com.example.demo.model.Transactions;
//import com.example.demo.model.Users;
//import com.example.demo.repository.TransactionRepository;
//import com.example.demo.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DatabaseLoader {
//    private static final Logger log =LoggerFactory.getLogger(DatabaseLoader.class);
//
//    @Bean
//    CommandLineRunner initDatabase(UserRepository userRepository, TransactionRepository transactionRepository){
//        return  args -> {
//            log.info("Preloading " +userRepository.save(new Users("HCM","12/12/1999","Hung")));
//            log.info("preLoading : "+ transactionRepository.save(new Transactions(1,1,2223,"Sacombank","deposit","22/10/1298")));
//        };
//    }
//}

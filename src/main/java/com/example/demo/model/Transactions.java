package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="transactions",schema = "public")
public class Transactions {
    @Id
    @GeneratedValue
    private int id;

    private int user_id;
    private int account_id;
    private double amount;
    private String bank;
    private String transaction_type;
    private Date created_at;

    public Transactions(){}
    public Transactions( int user_id, int account_id, double amount, String bank, String transaction_type, Date created_at){
        this.user_id = user_id;
        this.account_id = account_id;
        this.amount = amount;
        this.bank = bank;
        this.transaction_type = transaction_type;
        this.created_at = created_at;
    }
    public Transactions(double amount, String bank, String transaction_type){
        this.amount = amount;
        this.bank = bank;
        this.transaction_type = transaction_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public  Date getCreate_at() {
        return created_at;
    }

    public void setCreate_at(Date create_at) {
        this.created_at = create_at;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", account_id=" + account_id +
                ", amount=" + amount +
                ", bank='" + bank + '\'' +
                ", transaction_type='" + transaction_type + '\'' +
                ", create_at='" + created_at + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

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
    private Long id;

    private Long userId;
    private Long accountId;
    private Double amount;
    private String bank;
    private String transactionType;
    private Date createdAt;

    public Transactions(){}
    public Transactions( Long user_id, Long account_id, Double amount, String bank, String transaction_type, Date createdAt){
        this.userId = user_id;
        this.accountId = account_id;
        this.amount = amount;
        this.bank = bank;
        this.transactionType = transaction_type;
        this.createdAt = createdAt;
    }
    public Transactions(double amount, String bank, String transaction_type){
        this.amount = amount;
        this.bank = bank;
        this.transactionType = transaction_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public  Date getCreate_at() {
        return createdAt;
    }

    public void setCreate_at(Date create_at) {
        this.createdAt = create_at;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", user_id=" + userId +
                ", account_id=" + accountId +
                ", amount=" + amount +
                ", bank='" + bank + '\'' +
                ", transaction_type='" + transactionType + '\'' +
                ", create_at='" + createdAt + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

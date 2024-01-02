package com.zaio.Entity;

import com.zaio.Enum.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING) // Specify EnumType.STRING to store the enum as a string in the database
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "source_wallet_id")
    private Wallet sourceWallet;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    @ManyToOne
    @JoinColumn(name = "destination_wallet_id")
    private Wallet destinationWallet;

    // Constructors, getters, and setters go here

    public TransactionRecord() {
    }

    public TransactionRecord(Long transactionId, BigDecimal amount, TransactionType transactionType, LocalDateTime transactionDate, Account sourceAccount, Wallet sourceWallet, Account destinationAccount, Wallet destinationWallet) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.sourceAccount = sourceAccount;
        this.sourceWallet = sourceWallet;
        this.destinationAccount = destinationAccount;
        this.destinationWallet = destinationWallet;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Wallet getSourceWallet() {
        return sourceWallet;
    }

    public void setSourceWallet(Wallet sourceWallet) {
        this.sourceWallet = sourceWallet;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Wallet getDestinationWallet() {
        return destinationWallet;
    }

    public void setDestinationWallet(Wallet destinationWallet) {
        this.destinationWallet = destinationWallet;
    }

    // Additional methods if required
}

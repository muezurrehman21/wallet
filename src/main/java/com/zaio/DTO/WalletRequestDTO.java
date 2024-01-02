package com.zaio.DTO;

import com.zaio.Entity.Account;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WalletRequestDTO {

    private Long walletId;

    private String walletName;

    private BigDecimal balance;

    private Long accountId;

    public WalletRequestDTO() {
    }

    public WalletRequestDTO(Long walletId, String walletName, BigDecimal balance, Long accountId) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.balance = balance;
        this.accountId = accountId;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}

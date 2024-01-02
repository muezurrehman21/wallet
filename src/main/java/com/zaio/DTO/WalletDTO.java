package com.zaio.DTO;

import java.math.BigDecimal;

public class WalletDTO {
    private Long walletId;
    private String walletName;
    private BigDecimal balance;

    public WalletDTO() {
    }

    public WalletDTO(Long walletId, String walletName, BigDecimal balance) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.balance = balance;
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
}

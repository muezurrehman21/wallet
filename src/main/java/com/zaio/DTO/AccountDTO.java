package com.zaio.DTO;

import java.math.BigDecimal;
import java.util.List;

public class AccountDTO {
    private Long accountId;
    private String accountName;
    private BigDecimal totalAmount;
    private List<WalletDTO> wallets;
    private UserDTO user;

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, String accountName, BigDecimal totalAmount, List<WalletDTO> wallets, UserDTO user) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.totalAmount = totalAmount;
        this.wallets = wallets;
        this.user = user;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<WalletDTO> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletDTO> wallets) {
        this.wallets = wallets;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}

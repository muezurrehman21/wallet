package com.zaio.DTO;

import java.math.BigDecimal;

public class AccountRequestDTO {
    private Long accountId;

    private String accountName;

    private Long userId;


    public AccountRequestDTO() {
    }

    public AccountRequestDTO(Long accountId, String accountName, Long userId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

package com.zaio.DTO;

import java.math.BigDecimal;

public class TransferMoneyDTO {
    private Long sourceAccountId;
    private Long sourceWalletId;
    private Long destinationAccountId;
    private Long destinationWalletId;
    private BigDecimal amount;

    // Getters and setters


    public TransferMoneyDTO() {
    }

    public TransferMoneyDTO(Long sourceAccountId, Long sourceWalletId, Long destinationAccountId, Long destinationWalletId, BigDecimal amount) {
        this.sourceAccountId = sourceAccountId;
        this.sourceWalletId = sourceWalletId;
        this.destinationAccountId = destinationAccountId;
        this.destinationWalletId = destinationWalletId;
        this.amount = amount;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getSourceWalletId() {
        return sourceWalletId;
    }

    public void setSourceWalletId(Long sourceWalletId) {
        this.sourceWalletId = sourceWalletId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public Long getDestinationWalletId() {
        return destinationWalletId;
    }

    public void setDestinationWalletId(Long destinationWalletId) {
        this.destinationWalletId = destinationWalletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

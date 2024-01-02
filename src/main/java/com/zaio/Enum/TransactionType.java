package com.zaio.Enum;

public enum TransactionType {
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    TRANSFER_IN("TRANSFER_IN"),
    TRANSFER_OUT("TRANSFER_OUT");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

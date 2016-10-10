package ru.borisenko.gennady.accountingfinance.enums;


public enum OperationType {
    ALL("0"),
    INCOME("1"),
    OUTCOME("2");

    private String id;

    private OperationType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum Transaction {
    CSKH("Chăm sóc khách hàng"),
    DDX("Dẫn đi xem");

    private String transactionName;
    Transaction(String transactionName) {
        this.transactionName = transactionName;
    }
    public String getTransactionName() {
        return transactionName;
    }
    public static Map<String,String> getTransactionType() {
        Map<String,String> map = new HashMap<>();
        for(Transaction type : Transaction.values()) {
            map.put(type.toString(), type.getTransactionName());
        }
        return map;
    }
}

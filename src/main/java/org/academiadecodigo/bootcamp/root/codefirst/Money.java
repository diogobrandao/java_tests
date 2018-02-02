package org.academiadecodigo.bootcamp.root.codefirst;

public class Money {

    private  final int amount;
    private  final  String currency;

    public Money(int amount, String currency) {

        if(amount < 0) {
            throw new IllegalArgumentException("Illegal amount : [ " + amount + "]");

        }

        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}

package org.academiadecodigo.bootcamp.root.codefirst;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private final static int VALID_AMOUNT = 5;
    private final static int INVALID_AMOUNT = -10;
    private final static String VALID_CURRENCY = "EUR";
    private final static String INVALID_CURRENCY = "";


    private static final Object[] getMoney() {
        return new Object[]{
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"},
                new Object[] {15, "GBP"},
        };
    }

    private static final Object[] getInvalidAmount() {
        return new Integer [][]{{-123412}, {-5}, {-1}};  //array of arrays
    }

    @Test
    @Parameters(method = "getMoney")  //usar os varios valores do metodo get money
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {

        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());


    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void contructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        new Money(invalidAmount,VALID_CURRENCY);
    }

}
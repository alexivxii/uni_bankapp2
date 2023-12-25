package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;
import com.luxoft.bankapp.service.BankService;

//https://stackoverflow.com/questions/69849/factory-pattern-when-to-use-factory-methods

public class TestFactory {

    @Test
    public void testAccountFactory(){

        AbstractAccount account1 = AccountFactory.newAccount("CHECKING");
        System.out.println(account1.getClass().getSimpleName());

        AbstractAccount account2 = AccountFactory.newAccount("SAVING");
        System.out.println(account2.getClass().getSimpleName());
    }


}

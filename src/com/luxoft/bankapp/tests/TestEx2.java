package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;
import com.luxoft.bankapp.service.BankService;

public class TestEx2 {

    @Test
    public void testCloningDeepCopySavingAcc() throws CloneNotSupportedException {
        SavingAccount savingAccount = new SavingAccount(9, 1000.0);
        SavingAccount savingAccount2 = new SavingAccount(20, 0.0);

        // Clone the savingAccount object into savingAccount2
        savingAccount2 = (SavingAccount) savingAccount.clone();
        
        System.out.println(savingAccount);
        System.out.println(savingAccount.hashCode());
        System.out.println(savingAccount2);
        System.out.println(savingAccount2.hashCode());

        // Verify that the cloned object is identical to the original object
        assertEquals(savingAccount, savingAccount2);
    }

    @Test
    public void testCloningDeepCopyCheckingAcc() throws CloneNotSupportedException {
        CheckingAccount checkingAccount = new CheckingAccount(9, 1000.0, 100);
        CheckingAccount checkingAccount2 = new CheckingAccount(20, 0.0,200);

        // Clone the savingAccount object into savingAccount2
        checkingAccount2 = (CheckingAccount) checkingAccount.clone();

        System.out.println(checkingAccount);
        System.out.println(checkingAccount.hashCode());
        System.out.println(checkingAccount2);
        System.out.println(checkingAccount2.hashCode());

        // Verify that the cloned object is identical to the original object
        assertEquals(checkingAccount, checkingAccount2);
    }

    @Test
    public void testAccountCache(){

        AccountCache accCache = new AccountCache();

        accCache.displayCache();

        SavingAccount savingAccount = new SavingAccount(11, 1111.0);
        CheckingAccount checkingAccount = new CheckingAccount(22, 2222.0, 100);

        System.out.println("DISPLAYING ACCOUNTS CACHE");

        accCache.loadAccount(checkingAccount);
        accCache.displayCache();

        accCache.loadAccount(savingAccount);
        accCache.displayCache();

        //cloning from Cache
        System.out.println("CLONING FROM CACHE");

        SavingAccount savingAccountTemp = new SavingAccount(33, 3333.0);
        System.out.println("Temp acc hashcode before cloning " + savingAccountTemp.hashCode());

        //TODO: Unhandled exception: java.lang.CloneNotSupportedException
        //TODO: daca nu ii dau try catch, imi apare eroare de mai sus
        //TODO: chiar daca i am facut handle in AbstractAccount clone()

        try {
            savingAccountTemp = (SavingAccount) accCache.getCache(savingAccountTemp.getType()).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(savingAccountTemp);
        System.out.println("Temp acc hashcode after cloning " + savingAccountTemp.hashCode());


        CheckingAccount checkingAccountTemp = new CheckingAccount(44, 4444.0, 440 );
        System.out.println("Temp acc hashcode before cloning " + checkingAccountTemp.hashCode());

        try {
            checkingAccountTemp = (CheckingAccount) accCache.getCache(checkingAccountTemp.getType()).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(checkingAccountTemp);
        System.out.println("Temp acc hashcode after cloning " + checkingAccountTemp.hashCode());

        assertEquals(savingAccount, savingAccountTemp);
        assertEquals(checkingAccount, checkingAccountTemp);

    }
}

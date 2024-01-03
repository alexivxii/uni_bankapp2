package com.luxoft.bankapp.domain;

import java.util.*;


public class AccountCache {

    Map<String, AbstractAccount> accCacheMap = new HashMap<String, AbstractAccount>();

    //in constructor we make the map set up with default values
    public AccountCache(){
        accCacheMap.put("SAVING", new SavingAccount(0, 0.0));
        accCacheMap.put("CHECKING", new CheckingAccount(0, 0.0, 0));
    }

    public void displayCache(){

        // Iterating over Map
        for (Map.Entry<String, AbstractAccount> e : this.accCacheMap.entrySet())

            // Printing key-value pairs
            System.out.println(e.getKey() + " "
                    + e.getValue());

    }

    public void loadAccount(AbstractAccount acc){

        switch (acc.getType()) {
            case AbstractAccount.SAVING_ACCOUNT_TYPE:
                accCacheMap.put("SAVING", acc);
                break;
            case AbstractAccount.CHECKING_ACCOUNT_TYPE:
                accCacheMap.put("CHECKING", acc);
                break;
        }

    }

    public AbstractAccount getCache(int type) {

        if(type == AbstractAccount.SAVING_ACCOUNT_TYPE)
                return accCacheMap.get("SAVING");
        return accCacheMap.get("CHECKING");

    }

    //load cache
    //cloning an account

    //one method to overwrite the current cached accounts (one for saving acc, one for checking acc)
    //one method to get the account from cache in order to clone it to another account

}

package com.luxoft.bankapp.domain;

public class AccountFactory {

    public static AbstractAccount newAccount(String accountType){

        if(accountType == null){
            return null;
        }

        switch(accountType.toUpperCase()){

            case "CHECKING":
                return new CheckingAccount(-1,0.0,0.0);
            case "SAVING":
                return new SavingAccount(-1,0.0);
            default:
                return null;

        }

    }

}

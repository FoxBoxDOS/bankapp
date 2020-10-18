package ru.kazarin.springinterview.restapp.service;

import org.springframework.stereotype.Service;
import ru.kazarin.springinterview.restapp.model.BankAccount;

@Service
public class ValidateOperation {

    public boolean check(BankAccount bankAccount, long withdrawOrSendMoney){
        boolean toReturn = false;
        if (bankAccount.getCash() > withdrawOrSendMoney){
            toReturn = true;
        }
        return toReturn;
    }
}

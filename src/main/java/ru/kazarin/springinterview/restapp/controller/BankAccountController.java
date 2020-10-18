package ru.kazarin.springinterview.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kazarin.springinterview.restapp.model.BankAccount;
import ru.kazarin.springinterview.restapp.model.incomingmessage.AccountInfoMessage;
import ru.kazarin.springinterview.restapp.model.incomingmessage.DepositMoneyMessage;
import ru.kazarin.springinterview.restapp.model.incomingmessage.TransferMoneyMessage;
import ru.kazarin.springinterview.restapp.model.incomingmessage.WithdrawalMoneyMessage;
import ru.kazarin.springinterview.restapp.service.BankService;

import java.util.List;

@RestController
public class BankAccountController {
    @Autowired
    BankService bankService;

    @PostMapping("/createaccount")
    public String createAcc(@RequestBody BankAccount bankAccount){
        return bankService.createNewAcc(bankAccount);
    }

    @PostMapping("/allaccinfo")
    public List<BankAccount> getAllAccInfo(){
        return bankService.listAccInfo();
    }

    @PostMapping("/accinfo")
    public BankAccount getAccInfo (@RequestBody AccountInfoMessage accountInfoMessage){
        return bankService.getBankAccountInfo(accountInfoMessage.getAccNumber());
    }

    @PostMapping("/deposit")
    public String doDeposit (@RequestBody DepositMoneyMessage depositMoneyMessage){
        return bankService.deposit(depositMoneyMessage);
    }

    @PostMapping("/withdrawal")
    public String doWithdrawal(@RequestBody WithdrawalMoneyMessage withdrawalMoneyMessage){
        return bankService.withdrawal(withdrawalMoneyMessage);
    }

    @PostMapping("/transfer")
    public String doTransfer(@RequestBody TransferMoneyMessage transferMoneyMessage){
        return bankService.transferMoney(transferMoneyMessage);
    }
}

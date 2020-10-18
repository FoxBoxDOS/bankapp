package ru.kazarin.springinterview.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kazarin.springinterview.restapp.model.BankAccount;
import ru.kazarin.springinterview.restapp.model.incomingmessage.DepositMoneyMessage;
import ru.kazarin.springinterview.restapp.model.incomingmessage.TransferMoneyMessage;
import ru.kazarin.springinterview.restapp.model.incomingmessage.WithdrawalMoneyMessage;
import ru.kazarin.springinterview.restapp.repository.BankAccountRepository;

import java.util.List;

@Service
public class BankService {

    @Autowired
    BankAccountRepository bankAccountRepository;


    public BankAccount getBankAccountInfo(long accNumber){
        return bankAccountRepository.findByNumberOfAccount(accNumber);
    }

    public String createNewAcc(BankAccount bankAccount){
        String toReturn = "";
        if(!bankAccountRepository.existsByNumberOfAccount(bankAccount.getNumberOfAccount())) {
            bankAccountRepository.save(bankAccount);
            toReturn = "Аккаунт создан.";
        } else {
            toReturn = "Аккаунт не был создан так как аккаунт с таким счетом ужесуществует";
        }
        return toReturn;
    }

    public List<BankAccount> listAccInfo(){
        return bankAccountRepository.findAll();
    }

    public String deposit(DepositMoneyMessage depositMoneyMessage){
        String toReturn = "";
        if (bankAccountRepository.existsByNumberOfAccount(depositMoneyMessage.getDepositAccNumber())){
            BankAccount bankAccount = bankAccountRepository.findByNumberOfAccount(depositMoneyMessage.getDepositAccNumber());
            double totalCash = bankAccount.getCash() + depositMoneyMessage.getAmountOfMoneyToDeposit();
            bankAccount.setCash(totalCash);
            bankAccountRepository.save(bankAccount);
            toReturn = "Вы пополнили свой счет на " + depositMoneyMessage.getAmountOfMoneyToDeposit() + ". Total sum: "
                    + bankAccountRepository.findByNumberOfAccount(depositMoneyMessage.getDepositAccNumber()).getCash();
        } else {
            toReturn = "Счета с данным номером: \""+depositMoneyMessage.getDepositAccNumber()+"\" не существует";
        }
        return toReturn;
    }

    public String withdrawal(WithdrawalMoneyMessage withdrawalMoneyMessage){
        StringBuilder toReturn = new StringBuilder();
        if (bankAccountRepository.existsByNumberOfAccount(withdrawalMoneyMessage.getAccNumber())){
            BankAccount bankAccount = bankAccountRepository.findByNumberOfAccount(withdrawalMoneyMessage.getAccNumber());
            toReturn.append("На вашем счету: ").append(bankAccount.getCash()).append("\n");
            if (bankAccount.getCash() > withdrawalMoneyMessage.getWithdrawalCash()){
                bankAccount.setCash(bankAccount.getCash() - withdrawalMoneyMessage.getWithdrawalCash());
                bankAccountRepository.save(bankAccount);
                toReturn.append("Операция прошла успешно вы сняли: ").append(withdrawalMoneyMessage.getWithdrawalCash())
                        .append("\n").append("Остаток на счету: ").append(bankAccountRepository.findByNumberOfAccount(withdrawalMoneyMessage.getAccNumber()).getCash());

            } else {
                toReturn.append("Не хватает средств для операции");
            }
        } else {
            toReturn.append("Счета с данным номером: \"").append(withdrawalMoneyMessage.getAccNumber()).append("\" не существует");
        }

        return String.valueOf(toReturn);
    }

    public String transferMoney(TransferMoneyMessage transferMoneyMessage){
        StringBuilder toReturn = new StringBuilder();

        if (bankAccountRepository.existsByNumberOfAccount(transferMoneyMessage.getAccNumber())){
            if (bankAccountRepository.existsByNumberOfAccount(transferMoneyMessage.getTransferAccNumber())){
                BankAccount bankAccount = bankAccountRepository.findByNumberOfAccount(transferMoneyMessage.getAccNumber());
                toReturn.append("На вашем счету: ").append(bankAccount.getCash()).append("\n");
                if (bankAccount.getCash() > transferMoneyMessage.getTransferCash()){
                    bankAccount.setCash(bankAccount.getCash() - transferMoneyMessage.getTransferCash());
                    bankAccountRepository.save(bankAccount);
                    BankAccount transferBankAccount = bankAccountRepository.findByNumberOfAccount(transferMoneyMessage.getTransferAccNumber());
                    transferBankAccount.setCash(transferBankAccount.getCash() + transferMoneyMessage.getTransferCash());
                    bankAccountRepository.save(transferBankAccount);
                    toReturn.append("Операция выполнена успешно. Вы перевели: ").append(transferMoneyMessage.getTransferCash())
                            .append(" на счет ").append(transferMoneyMessage.getTransferAccNumber()).append("\n");
                    toReturn.append("Остаток на вашем счету: ").append(bankAccountRepository.findByNumberOfAccount(transferMoneyMessage.getAccNumber()).getCash());
                }else {
                    toReturn.append("Не хватает средств на операцию");
                }
            } else {
              // счет которому перевести не найлен
                toReturn.append("Cчета для перевода \"").append(transferMoneyMessage.getTransferAccNumber()).append("\" не существует");
            }
        } else {
            // свой счет
            toReturn.append("Вашего счета \"").append(transferMoneyMessage.getAccNumber()).append("\" не существует");
        }
        return String.valueOf(toReturn);
    }


}

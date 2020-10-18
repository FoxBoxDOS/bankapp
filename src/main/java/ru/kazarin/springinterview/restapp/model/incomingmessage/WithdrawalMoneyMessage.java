package ru.kazarin.springinterview.restapp.model.incomingmessage;

public class WithdrawalMoneyMessage implements Message{
    private long accNumber;
    private double withdrawalCash;

    public WithdrawalMoneyMessage(){}

    public WithdrawalMoneyMessage(long accNumber, double withdrawalCash){
        this.accNumber = accNumber;
        this.withdrawalCash = withdrawalCash;
    }

    public double getWithdrawalCash() {
        return withdrawalCash;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public void setWithdrawalCash(double withdrawalCash) {
        this.withdrawalCash = withdrawalCash;
    }
}

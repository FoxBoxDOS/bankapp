package ru.kazarin.springinterview.restapp.model.incomingmessage;

public class DepositMoneyMessage implements Message {
    private double amountOfMoneyToDeposit;
    private long depositAccNumber;

    public DepositMoneyMessage (){}

    public DepositMoneyMessage (long depositAccNumber, double amountOfMoneyToDeposit){
        this.amountOfMoneyToDeposit = amountOfMoneyToDeposit;
        this.depositAccNumber = depositAccNumber;
    }

    public double getAmountOfMoneyToDeposit() {
        return amountOfMoneyToDeposit;
    }

    public long getDepositAccNumber() {
        return depositAccNumber;
    }

    public void setAmountOfMoneyToDeposit(double amountOfMoneyToDeposit) {
        this.amountOfMoneyToDeposit = amountOfMoneyToDeposit;
    }

    public void setDepositAccNumber(long depositAccNumber) {
        this.depositAccNumber = depositAccNumber;
    }
}

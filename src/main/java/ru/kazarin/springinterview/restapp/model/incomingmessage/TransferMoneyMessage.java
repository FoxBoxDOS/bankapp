package ru.kazarin.springinterview.restapp.model.incomingmessage;

public class TransferMoneyMessage implements Message {
    private long accNumber;
    private long transferAccNumber;
    private double transferCash;

    public TransferMoneyMessage(){}

    public TransferMoneyMessage(long accNumber, long transferAccNumber, double transferCash){
        this.accNumber = accNumber;
        this.transferCash = transferCash;
        this.transferAccNumber = transferAccNumber;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public double getTransferCash() {
        return transferCash;
    }

    public long getTransferAccNumber() {
        return transferAccNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public void setTransferAccNumber(long transferAccNumber) {
        this.transferAccNumber = transferAccNumber;
    }

    public void setTransferCash(double transferCash) {
        this.transferCash = transferCash;
    }
}

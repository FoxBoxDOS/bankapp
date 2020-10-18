package ru.kazarin.springinterview.restapp.model.incomingmessage;

public class AccountInfoMessage {
    private long accNumber;

    public AccountInfoMessage(){}

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }
}

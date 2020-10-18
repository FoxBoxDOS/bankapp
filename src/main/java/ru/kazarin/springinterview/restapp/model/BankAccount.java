package ru.kazarin.springinterview.restapp.model;


import javax.persistence.*;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

    private long id; //id в базеданных

    private long numberOfAccount; // номер счета

    private double cash; // сумма на счету


    public BankAccount(){

    }

    public BankAccount(long numberOfAccount, double cash){
        this.numberOfAccount = numberOfAccount;
        this.cash = cash;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "cash", nullable = false)
    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }


    @Column(name = "numberOfAccount", nullable = false)
    public long getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(long numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }

    public static BankAccount create(long numberOfAccount, double cash){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumberOfAccount(numberOfAccount);
        bankAccount.setCash(cash);
        return bankAccount;
    }

}

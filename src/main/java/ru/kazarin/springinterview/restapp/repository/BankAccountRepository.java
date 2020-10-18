package ru.kazarin.springinterview.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kazarin.springinterview.restapp.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    BankAccount findByNumberOfAccount(long accNumber);
    boolean existsByNumberOfAccount(Long accNumber);

}

package ru.kazarin.springinterview.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.kazarin.springinterview.restapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

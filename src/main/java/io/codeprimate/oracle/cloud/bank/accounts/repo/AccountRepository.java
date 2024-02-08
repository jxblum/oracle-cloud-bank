package io.codeprimate.oracle.cloud.bank.accounts.repo;

import io.codeprimate.oracle.cloud.bank.accounts.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Data Access Object (DAO) and Spring Data {@link JpaRepository} used to run basic CRUD and simple query
 * data access operations on {@link Account Accounts}.
 *
 * @author John Blum
 * @see Account
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @since 1.0.0
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}

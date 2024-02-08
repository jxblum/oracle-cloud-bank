package io.codeprimate.oracle.cloud.bank.accounts.service;

import java.util.List;

import io.codeprimate.oracle.cloud.bank.accounts.model.Account;
import io.codeprimate.oracle.cloud.bank.accounts.repo.AccountRepository;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Spring {@link Service} component used to process and service {@link Account Accounts}
 * stored and managed in the Cloud Bank application.
 *
 * @author John Blum
 * @see io.codeprimate.oracle.cloud.bank.accounts.model.Account
 * @see org.springframework.stereotype.Service
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class AccountService {

	private final AccountRepository accountRepository;

	public List<Account> getAll() {
		return getAccountRepository().findAll();
	}

	public Account get(Long id) {
		return getAccountRepository().findById(id).orElseThrow();
	}

	public Account save(Account account) {
		return getAccountRepository().saveAndFlush(account);
	}
}

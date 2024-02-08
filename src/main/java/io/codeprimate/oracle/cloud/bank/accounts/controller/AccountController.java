package io.codeprimate.oracle.cloud.bank.accounts.controller;

import java.net.URI;
import java.util.List;

import io.codeprimate.oracle.cloud.bank.accounts.model.Account;
import io.codeprimate.oracle.cloud.bank.accounts.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Spring Web MVC {@link RestController} for CloudBank {@link Account Accounts}.
 *
 * @author John Blum
 * @see Account
 * @see AccountService
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.RestController
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class AccountController {

	private final AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> accounts() {
		return getAccountService().getAccounts();
	}

	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable(name = "id") Long id) {
		return getAccountService().getAccount(id);
	}

	@PostMapping(value = "/accounts")
	public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
		return ResponseEntity.created(URI.create("/accounts/{id}"))
			.body(getAccountService().createAccount(account));
	}

	@ExceptionHandler
	public ResponseEntity<?> exceptionHandler(Throwable error) {
		return ResponseEntity.internalServerError().build();
	}
}

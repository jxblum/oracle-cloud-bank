package io.codeprimate.oracle.cloud.bank.accounts;

import io.codeprimate.oracle.cloud.bank.accounts.model.Account;

/**
 * Java {@link RuntimeException} thrown when an {@link Account} could not be found.
 *
 * @author John Blum
 * @see java.lang.RuntimeException
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException() {

	}

	public AccountNotFoundException(String message) {
		super(message);
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

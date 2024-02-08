package io.codeprimate.oracle.cloud.bank.accounts.model;

import java.math.BigDecimal;
import java.util.Date;

import org.cp.elements.lang.Identifiable;
import org.cp.elements.lang.Nameable;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract Data Type for Accounts.
 *
 * @author John Blum
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 * @see org.cp.elements.lang.Identifiable
 * @see org.cp.elements.lang.Nameable
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Account implements Identifiable<Long>, Nameable<String> {

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ACCOUNT_BALANCE")
	private BigDecimal balance;

	@Setter(AccessLevel.NONE)
	@Generated(GenerationTime.INSERT)
	@Column(name = "ACCOUNT_OPENED_DATE", updatable = false, insertable = false)
	private Date openedDate;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "ACCOUNT_NAME")
	private String name;

	@Column(name = "ACCOUNT_OTHER_DETAILS")
	private String otherDetails;

	@Column(name = "ACCOUNT_TYPE")
	@Enumerated(EnumType.STRING)
	private Type type;

	public Account(String name, Type type, String otherDetails, String customerId) {

		this.name = name;
		this.type = type;
		this.otherDetails = otherDetails;
		this.customerId = customerId;
	}

	enum Type {
		CHECKING, CREDIT, LOAN, SAVINGS
	}
}

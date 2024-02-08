package io.codeprimate.oracle.cloud.bank.database;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Unit Tests to assert the presence of the Oracle Driver and associated types.
 *
 * @author John Blum
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@SpringBootTest
@ContextConfiguration
@Getter(AccessLevel.PROTECTED)
public class OracleDriverUnitTests {

	@Autowired
	private Environment environment;

	@Test
	void oracleDriverIsPresent() throws ClassNotFoundException {
		assertThat(Class.forName(getEnvironment().getProperty("spring.datasource.driver-class-name"))).isNotNull();
	}

	@Test
	void oracleDialectIsPresent() throws ClassNotFoundException {
		assertThat(Class.forName(getEnvironment().getProperty("spring.jpa.properties.hibernate.dialect"))).isNotNull();
	}

	@SpringBootConfiguration
	static class TestConfiguration {

	}
}

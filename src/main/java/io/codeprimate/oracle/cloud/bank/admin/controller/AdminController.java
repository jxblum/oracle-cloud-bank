package io.codeprimate.oracle.cloud.bank.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Web MVC {@link RestController} for admin functions.
 *
 * @author John Blum
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.RestController
 * @since 1.0.0
 */
@RestController
@RequestMapping("/admin")
@SuppressWarnings("unused")
public class AdminController {

	@GetMapping("/hello")
	public String hello() {
		return "<h1>Hello %s</h2>".formatted(System.getProperty("user.name"));
	}

	@GetMapping("/ping")
	public String ping() {
		return "<h1>PONG</h1>";
	}
}

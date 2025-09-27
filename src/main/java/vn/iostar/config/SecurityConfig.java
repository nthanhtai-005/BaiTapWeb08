package vn.iostar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public UserDetailsService userDS (PasswordEncoder en) {
		UserDetails admin = User.withUsername("tai")
				.password(en.encode("123"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("user")
				.password(en.encode("123"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	@Bean
	PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
}

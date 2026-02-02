package com.portfolio.my_portfolio_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.portfolio.my_portfolio_backend.service.IUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // ya no es necesario
@RequiredArgsConstructor
public class WebSecurityConfig {

	private final IUserDetailsService userDetailsService;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// .csrf(AbstractHttpConfigurer::disable) // desactiva csrf peligro de seguridad
				.authorizeHttpRequests(
						auth -> auth
								.requestMatchers("/education", "/experience", "/skill",
										"/personal-info", "/projects")
								.authenticated()
								.requestMatchers("/education/new", "/education/save",
										"/education/edit",
										"/education/edit/**",
										"/education/delete",
										"/education/delete/**")
								.authenticated()
								.requestMatchers("/experience/new", "/experience/save",
										"/experience/edit",
										"/experience/edit/**",
										"/experience/delete",
										"/experience/delete/**")
								.authenticated()
								.requestMatchers("/skill/new", "/skill/save",
										"/skill/edit",
										"/skill/edit/**", "/skill/delete",
										"/skill/delete/**")
								.authenticated()
								.requestMatchers("/personal-info/save",
										"/personal-info/edit",
										"/personal-info/edit/**",
										"/personal-info/create")
								.authenticated()
								.requestMatchers("/projects/new-project",
										"/projects/save",
										"/projects/edit/**",
										"/projects/delete/**")
								.authenticated()

								// Rutas de busqueda de personalInfoid tambien deben ser
								// protegidas si
								// son para
								// adminitracion
								.requestMatchers("/education/personal/**",
										"/experience/personal/**",
										"/skill/personal/**",
										"/personal-info/personal/**",
										"/projects/personal/**")
								.authenticated()
								.anyRequest().permitAll())
				.formLogin(form -> form.loginPage("/login").permitAll())
				.logout(logout -> logout
						.logoutUrl("/logout")
						// .logoutRequestMatcher(req -> "GET".equalsIgnoreCase(req.getMethod())
						// && "/logout".equals(req.getRequestURI())) // inseguro
						.logoutSuccessUrl("/login?logout")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.permitAll());

		return http.build();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// @Bean
	// UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	// UserDetails user = User.withUsername("admin")
	// .password(passwordEncoder.encode("1234"))
	// .roles("ADMIN")
	// .build();

	// return new InMemoryUserDetailsManager(user);
	// }

}

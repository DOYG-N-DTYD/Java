package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tacos.Interfaces.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());

		return http.build();
	}
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth->{
//                    auth
//                            .requestMatchers("/design", "/orders").hasRole("USER")
//                            .requestMatchers("/", "/**").permitAll();})
////                .formLogin(loginConf->{
////                    loginConf
////                            .loginPage("/login")
////                            .loginProcessingUrl("/login")
////                            .usernameParameter("username")
////                            .passwordParameter("password")
////                            .defaultSuccessUrl("/design");})
//                .formLogin(loginConf-> {})
//                .csrf(csrfConf->{
//                    csrfConf.ignoringRequestMatchers("/h2-console/**");
//                })
//                .headers(headersConf ->
//                        headersConf
//                                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .build();
//    }

	@Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		ProviderManager providerManager = new ProviderManager(authenticationProvider);
		providerManager.setEraseCredentialsAfterAuthentication(false);

		return providerManager;
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails userDetails = User.builder()
//			.username("sa")
//			.password(passwordEncoder().encode("sa"))
//			.roles("USER")
//			.build();
//
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService(UserRepository userRepo) {
	  return username -> userRepo.findByUsername(username);
	}
}


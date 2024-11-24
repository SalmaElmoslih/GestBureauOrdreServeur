////package com.serveur.serveurGestBureauOrdre.Security;
////
////import javax.crypto.spec.SecretKeySpec;
////
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.ProviderManager;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
////import org.springframework.security.oauth2.jwt.JwtDecoder;
////import org.springframework.security.oauth2.jwt.JwtEncoder;
////import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
////import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.CorsConfigurationSource;
////import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
////
////import com.nimbusds.jose.jwk.source.ImmutableSecret;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////	
////	@Value("${jwt.secret}")
////	private String secretKey;
////	
////	@Bean
////	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////		PasswordEncoder passwordEncoder = passwordEncoder();
////		return new InMemoryUserDetailsManager(
////			User.withUsername("user1").password(passwordEncoder.encode("123")).authorities("USER").build(),
////			User.withUsername("admin").password(passwordEncoder.encode("123")).authorities("USER" , "ADMIN").build()
////		);
////	}
////	
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
////	
////	@Bean
////	CorsConfigurationSource corsConfigurationSource() {
////	    CorsConfiguration corsConfiguration = new CorsConfiguration();
////	    corsConfiguration.addAllowedOrigin("*"); // Autoriser toutes les origines
////	    corsConfiguration.addAllowedMethod("*"); // Autoriser toutes les méthodes (GET, POST, etc.)
////	    corsConfiguration.addAllowedHeader("*"); // Autoriser tous les en-têtes
////	    // corsConfiguration.setExposedHeaders(List.of("x-auth-token")); // Optionnel : Expose certains headers si nécessaire
////
////	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////	    source.registerCorsConfiguration("/**", corsConfiguration); // Appliquer les règles à toutes les routes
////	    return source;
////	}
////	
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////	    http
////	        .cors() // Activer CORS
////	        .and()
////	        .csrf().disable() // Désactiver CSRF pour les APIs REST
////	        .authorizeRequests()
////	        .requestMatchers("/login").permitAll() // Permettre l'accès à l'endpoint /login sans authentification
////	        .anyRequest().authenticated()
////	        .and()
////	        .formLogin().disable(); // Désactiver la page de login par défaut
////
////	    return http.build();
////	}
//
//	
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////		return httpSecurity
////				.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////				.csrf(csrf->csrf.disable())
////				.authorizeHttpRequests(ar->ar.requestMatchers("/auth/login").permitAll())
////				.authorizeHttpRequests(ar->ar.anyRequest().authenticated())
////				//.httpBasic(User.withDefaults())
////				.oauth2ResourceServer(oa->oa.jwt(Customizer.withDefaults()))
////				.build();
////	}
////	
////	@Bean
////	JwtEncoder jwtEncoder() {
////		return new NimbusJwtEncoder(new ImmutableSecret<> (secretKey.getBytes()));
////	}
////	
////	@Bean 
////	JwtDecoder jwtDecoder() {
////		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes() , "HmacSHA512");
////		return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
////	}
////	
////	@Bean
////	public AuthenticationManager authenticationManager(UserDetailsService UserDetailsService) {
////		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////		daoAuthenticationProvider.setUserDetailsService(UserDetailsService);
////		return new ProviderManager(daoAuthenticationProvider);
////		
////	}
//}

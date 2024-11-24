//package com.serveur.serveurGestBureauOrdre.Security;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class SecurityController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
//        try {
//            // Authentifier l'utilisateur
//            Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//            );
//
//            // Si l'authentification réussit, renvoie une réponse JSON
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Login successful");
//            return ResponseEntity.ok(response);
//
//        } catch (AuthenticationException e) {
//            // Si l'authentification échoue
//            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
//        }
//    }
//}


//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
//import org.springframework.security.oauth2.jwt.JwsHeader;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class SecurityController {
//
//		
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	 @Autowired
//	    private JwtEncoder jwtEncoder;
//	
//	@GetMapping("/profile")
//	public Authentication authentication(Authentication authentification) {
//		return authentification;
//		
//	}
//	
//	@PostMapping("/login")
//	public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
//	    Authentication authentication = 
//	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//
//	    Instant instant = Instant.now();
//	    String scope = authentication.getAuthorities().stream()
//	            .map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
//
//	    JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
//	            .issuedAt(instant)
//	            .expiresAt(instant.plus(10, ChronoUnit.MINUTES))
//	            .subject(username)
//	            .claim("scope", scope)
//	            .build();
//
//	    JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
//	            JwsHeader.with(MacAlgorithm.HS512).build(),
//	            jwtClaimsSet
//	    );
//	    String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
//
//	    return Map.of("access-token", jwt);
//	}
//
//}





package com._SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com._SpringSecurity.security.JwtFilter;
import com._SpringSecurity.security.MyUserDetailsService;

@Configuration
//@EnableWebSecurity()
//@ConditionalOnDefaultWebSecurity
public class SecurityConfig {
	
	@Autowired
	MyUserDetailsService userDetailService;
	
	@Autowired
	JwtFilter jwtFilter;
	
			@Bean
			 SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {			
				return http
						
						.csrf(customizer-> customizer.disable())
						.authorizeHttpRequests(request-> request
														.requestMatchers("/v1/login",
																	"/v1/emp/{}", 
																	"/v1/saveEmp",
																	"/v1/getAllProduct",
																	"/v1/getProductById/{}").permitAll()
														.anyRequest().authenticated())
						.httpBasic(Customizer.withDefaults())
						.sessionManagement(session-> 
									session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
						.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
						.cors(cors -> {
			                cors.configurationSource(corsConfigurationSource());
			            })
						.build();
					
			}
			
			@Bean 
			public  AuthenticationProvider authenticationProvider() {
				DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
				provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
				provider.setUserDetailsService(userDetailService);
				return provider;
			}
			
			@Bean
			public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {				
				return authenticationConfiguration.getAuthenticationManager();
				
			}
			
			 @Bean
			    public CorsConfigurationSource corsConfigurationSource() {
			        CorsConfiguration configuration = new CorsConfiguration();
			        configuration.addAllowedOrigin("http://127.0.0.1:5500/"); 
			        configuration.addAllowedMethod("*"); 
			        configuration.addAllowedHeader("*"); 
			        configuration.setAllowCredentials(true);
			        UrlBasedCorsConfigurationSource source = new 
			         UrlBasedCorsConfigurationSource();
			        source.registerCorsConfiguration("/**", configuration);
			        return source;
			    }
			
}

package com._SpringSecurity.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class JwtFilter extends OncePerRequestFilter 
					{

	static {
		System.out.println("this is Static blick oc once perRe,,.566666666666");
	}
	
	
	@Autowired
  private JWTService jwtService;
	
	@Autowired
	ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 final String authHeader=request.getHeader("Authorization");
		 String token  = null;
		  String username = null;
		  
		  if(authHeader != null && authHeader.startsWith("Bearer ") ) {
			
			  token=authHeader.substring(7);
			  username= jwtService.extractUserName(token);
		  }
		  System.out.println("security contax Holder: "+SecurityContextHolder.getContext().getAuthentication());
		  
		  if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			  UserDetails userDetails= context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
			 
			  if(jwtService.validateToken(token,userDetails)) {
				  UsernamePasswordAuthenticationToken authToken= 
						  	new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				  		authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
				  		SecurityContextHolder.getContext().setAuthentication(authToken);
				  		
			  }
		
	}
		  else if(SecurityContextHolder.getContext().getAuthentication()!=null){
			  WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
			  
			  System.out.println("security contax Holder inside: "+SecurityContextHolder.getContext().getAuthentication().getDetails());
			  System.out.println("session id : "+details.getSessionId());
		  }
		  	filterChain.doFilter(request, response);
	}
	}

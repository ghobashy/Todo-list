package com.celonis.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;

import com.celonis.models.AuthUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class TokenAuthenticationService {

    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";
    public void addAuthentication(HttpServletResponse response, String username)
    {
        // We generate a token now.
        String JWT = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        response.addHeader(headerString,tokenPrefix + " "+ JWT);
    }
    
    public void addHeader(HttpHeaders headers, String username)
    {
        // We generate a token now.
        String JWT = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        headers.add(headerString,tokenPrefix + " "+ JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request)
    {
        String token = request.getHeader(headerString);
        if(token != null)
        {
            // parse the token.
            String username = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            if(username != null) // we managed to retrieve a user
            {
            	AuthUser user = new AuthUser();
            	user.setUsername(username);
                return user;
            }
        }
        return null;
    }
}

package com.ltnc.JavaApp.Authentication;

import com.ltnc.JavaApp.Service.AccountService.CustomUserDetails;
import com.ltnc.JavaApp.Service.AccountService.UserAccountService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGeneratorValidator {


    private final String SECRET = "LTNCHospitalApp";
    private final long JWT_EXPIRATION = 604800000L;

    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder().claim("role",userDetails.getAuthorities())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        if(userDetails==null) return false;
        Claims claims = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject().equals(userDetails.getUsername()) && claims.getExpiration().after(new Date());
    }


}

package tn.isi.worldcup.security.auth;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.isi.worldcup.security.jwt.JWTService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public class JWTRequestFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    public JWTRequestFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = request.getHeader(AUTHORIZATION);
            Authentication authentication = jwtService.validateToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JWTVerificationException ex) {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }

}

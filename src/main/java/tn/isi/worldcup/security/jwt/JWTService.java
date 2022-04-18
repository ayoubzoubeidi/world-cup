package tn.isi.worldcup.security.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface JWTService {

    void createTokenResponse(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException;
    Authentication validateToken(String token) throws JWTVerificationException;
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

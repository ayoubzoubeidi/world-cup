package tn.isi.worldcup.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.ApplicationUser;
import tn.isi.worldcup.mapper.UserMapper;
import tn.isi.worldcup.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class JWTServiceImpl implements JWTService {

    private final Algorithm algorithm;
    private final ObjectMapper objectMapper;
    private final JWT jwt;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final String expiration;
    private final String refreshExpiration;
    private final JWTVerifier jwtVerifier;

    public JWTServiceImpl(@Value("${application.jwt.secretKey}") String secretKey,
                          @Value("${application.jwt.tokenExpiration}") String expiration,
                          @Value("${application.jwt.refresh.tokenExpiration}") String refreshExpiration,
                          ObjectMapper objectMapper, UserRepository userRepository, UserMapper userMapper) {
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwt = new JWT();
        this.expiration = expiration;
        this.refreshExpiration = refreshExpiration;
        this.jwtVerifier = JWT.require(algorithm).build();
    }

    @Override
    public void createTokenResponse(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String accessToken = createToken(authentication, expiration, request);

        String refreshToken = createToken(authentication, refreshExpiration, request);

        createTokenJsonResponse(accessToken, refreshToken, authentication, response);
    }

    @Override
    public Authentication validateToken(String token) throws JWTVerificationException {
        jwtVerifier.verify(token);
        DecodedJWT decodedJWT = jwt.decodeJwt(token);
        String username = decodedJWT.getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, null);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String token = request.getHeader(AUTHORIZATION);

        Authentication authentication = validateToken(token);

        String accessToken = createToken(authentication, expiration, request);

        String refreshToken = createToken(authentication, refreshExpiration, request);

        createTokenJsonResponse(accessToken, refreshToken, authentication, response);

    }

    private void createTokenJsonResponse(String accessToken, String refreshToken, Authentication authentication, HttpServletResponse response) throws IOException {
        Map<String, Object> tokens = new HashMap<>();

        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);

        ApplicationUser user =
                userRepository
                        .findByUsername(authentication.getName()).orElseThrow(RuntimeException::new);

        tokens.put("user", userMapper.userToUserDto(user));
        response.setContentType(APPLICATION_JSON_VALUE);

        objectMapper.writeValue(response.getOutputStream(), tokens);

    }

    private String createToken(Authentication authentication, String expiration, HttpServletRequest request) {
        return jwt.create()
                .withSubject(authentication.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + Long.parseLong(expiration)))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
    }
}

package tn.isi.worldcup.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tn.isi.worldcup.security.jwt.JWTService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller @RequiredArgsConstructor
public class TokenController {

    private final JWTService jwtService;

    @GetMapping("/refresh")
    public void refreshTokenEndpoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        jwtService.refreshToken(request, response);
    }

}

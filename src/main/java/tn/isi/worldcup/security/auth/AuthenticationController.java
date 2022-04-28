package tn.isi.worldcup.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.isi.worldcup.dto.UserDto;
import tn.isi.worldcup.security.jwt.JWTService;
import tn.isi.worldcup.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller @RequiredArgsConstructor
public class AuthenticationController {

    private final JWTService jwtService;
    private final UserService userService;

    @GetMapping("/refresh")
    public void refreshTokenEndpoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        jwtService.refreshToken(request, response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        System.err.println("HELLO");
        userService.createUser(userDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

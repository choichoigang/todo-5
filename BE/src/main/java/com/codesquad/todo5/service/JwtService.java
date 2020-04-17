package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.domain.user.UserRepository;
import com.codesquad.todo5.exception.JwtMissingException;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class JwtService {

    private final UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(JwtService.class);
    private String secretKey = "JinIsTheBest";

    public JwtService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String makeJwt(HttpServletRequest req) {
        final SignatureAlgorithm SIGNATUREALGORITHM = SignatureAlgorithm.HS256;
        final String USER_NAME = "userName";
        final String TEAM = "TEAM";
        final String TYP = "typ";
        final String ALG = "HS256";

        Map<String, Object> header = new HashMap<>();
        header.put(TYP, "JWT");
        header.put(ALG, "HS256");

        Map<String, Object> payload = new HashMap<>();
        payload.put(USER_NAME, "codesquad");
        payload.put(TEAM, "TODO5");

        return Jwts.builder()
                .setHeader(header)
                .setClaims(payload)
                .signWith(SIGNATUREALGORITHM, secretKey.getBytes())
                .compact();
    }

    public String findJwtTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        logger.info("cookie: {}", cookies);
        for (Cookie cookie : cookies) {
            logger.info("cookie: {}", cookie);
            if (cookie.getName().equals("jwtToken")) {
                return cookie.getValue();
            }
        }

        throw new JwtMissingException();
    }

    public boolean isValidJwtToken(String decodedJwtTokenString) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(decodedJwtTokenString)
                    .getBody();
            return true;
        } catch (JwtMissingException e) {
            return false;
        }
    }

//
//    public User getTokenFromJwtString(String jwtToken, String signingKey) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(signingKey.getBytes())
//                .parseClaimsJws(jwtToken)
//                .getBody();
//
//        String userName = claims.get("userName", String.class);
//        //Long id = claims.get("id", Long.class);
//
//        User user = userRepository.findByName(userName).orElseThrow(ResourceNotFoundException::new);
//        if(!user.isMatchWithUserName(userName)){
//            throw new ResourceNotFoundException();
//        }
//
//        return user;
//    }
}
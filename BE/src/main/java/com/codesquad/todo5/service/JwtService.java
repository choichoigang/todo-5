package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.domain.user.UserRepository;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

  private final UserRepository userRepository;

  public JwtService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getTokenFromJwtString(String jwtTokenString, String signingKey) throws InterruptedException {
    Claims claims = Jwts.parser()
        .setSigningKey(signingKey.getBytes())
        .parseClaimsJws(jwtTokenString)
        .getBody();

    String userName = claims.get("userName", String.class);
    //Long id = claims.get("id", Long.class);

    User user = userRepository.findByName(userName).orElseThrow(ResourceNotFoundException::new);
    if(!user.isMatchWithUserName(userName)){
      throw new ResourceNotFoundException();
    }

    return user;
  }
}

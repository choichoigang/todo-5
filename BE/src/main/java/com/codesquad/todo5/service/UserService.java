package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.domain.user.UserRepository;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional(readOnly = true)
  public User getUserByName(String name) {
    return userRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException());
  }

  @Transactional(readOnly = true)
  public User getUserNameofTask(String name) {
    return userRepository.findTaskByUserName(name);
  }
}

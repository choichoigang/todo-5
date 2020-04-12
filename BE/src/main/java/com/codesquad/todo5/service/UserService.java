package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.domain.user.UserRepository;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final ActivityRepository activityRepository;
  private final UserRepository userRepository;

  public UserService(ActivityRepository activityRepository, UserRepository userRepository) {
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  @Transactional(readOnly = true)
  public User getUserByName(String name) {
    return userRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException());
  }

  @Transactional(readOnly = true)
  public User getUserById(Long userId) {
    return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
  }

  @Transactional(readOnly = true)
  public User getUserNameofTask(String name) {
    return userRepository.findTaskUserName(name);
  }

  @Transactional(readOnly = true)
  public List<Activity> getUserActivityList(Long userId) {
    return activityRepository.findAllActivityByUserId(userId).orElseThrow(() -> new ResourceNotFoundException());
    //TODO 왜 위에서는 List<Activity>라고 선언해주었는데도 orElseThrow의 선언이 가능하지? activityRepository는 Optional로 선언하지 않았을 때는 orElseThrow의 선언이 불가능했던 것을 생각해보자.
  }
}

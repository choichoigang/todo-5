package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

  private final TaskRepository taskRepository; //대체 final이 왜 붙징

  private final ActivityRepository activityRepository;

  private final UserRepository userRepository;

  public ActivityService(TaskRepository taskRepository,
      ActivityRepository activityRepository,
      UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  public void saveActivityLog(Activity activity, String userName, Long userId) {
    activity.setUserName(userName);
    activity.setUserId(userId);
    activityRepository.save(activity);
  }

  public void saveActivityLog(Activity activity, String userName, Long userId, Long categoryFrom,
      Long categoryTo) {
    activity.setUserName(userName);
    activity.setUserId(userId);
    activity.setCategoryFrom(categoryFrom);
    activity.setCategoryTo(categoryTo);
    activityRepository.save(activity);
  }

  public void saveActivityLog(Activity activity, String userName, Long userId, Long categoryFrom,
      Long categoryTo, String previousTargetName, String nextTargetName) {
    activity.setUserName(userName);
    activity.setUserId(userId);
    activity.setCategoryFrom(categoryFrom);
    activity.setCategoryTo(categoryTo);
    activityRepository.save(activity);
  }

}

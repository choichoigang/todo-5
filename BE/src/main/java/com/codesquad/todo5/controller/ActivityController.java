package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.dto.activity.UserActivityResponseDto;
import com.codesquad.todo5.service.ActivityService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActivityController {

  private final ActivityService activityService;

  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  @GetMapping("/activity/all")
  public List<UserActivityResponseDto> getUserActivityList() {

    List<Activity> nowUserActivities = activityService.getAllActivityList();
    List<UserActivityResponseDto> userActivityResponseDtoList =
        //테스트 이므로 유저 네임은 하드코딩
        nowUserActivities.stream().map(activityitem -> new UserActivityResponseDto(activityitem, "jypthemiracle")).collect(
            Collectors.toList());
    return userActivityResponseDtoList;
  }
}

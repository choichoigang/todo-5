package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.ActionItem;
import com.codesquad.todo5.domain.ActivityItem;
import com.codesquad.todo5.domain.UserItem;
import com.codesquad.todo5.dto.ActivityItemDto;
import com.codesquad.todo5.dto.TaskItemDto;
import com.codesquad.todo5.utils.ApiResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActivityController {
  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @GetMapping("/{membernum}/activity")
  public ResponseEntity<ApiResponse> showUserActivity(@RequestParam String membernum) {
    logger.debug("Number of a member: {} ", membernum);
    ActivityItemDto userActivityDto = new ActivityItemDto();
    List<ActivityItemDto> userActivityDtoList = new ArrayList<>();

    ActivityItem activityItem1 = new ActivityItem();
    UserItem userItem1 = UserItem.create("sigrid");
    activityItem1.setUserItem(userItem1);
    activityItem1.setActionItem(ActionItem.ADD);
    activityItem1.setId(1L);
    activityItem1.setCreatedDate("2020-04-05 12:30:32");
    activityItem1.setTaskTitle("github 공부하기");

    ActivityItem activityItem2 = new ActivityItem();
    activityItem2.setUserItem(userItem1);
    activityItem2.setActionItem(ActionItem.REMOVE);
    activityItem2.setId(2L);
    activityItem2.setCreatedDate("2020-04-06 12:30:32");
    activityItem2.setTaskTitle("java 공부하기");

    ActivityItem activityItem3 = new ActivityItem();
    activityItem3.setUserItem(userItem1);
    activityItem3.setActionItem(ActionItem.MOVE);
    activityItem3.setCategoryFrom(String.valueOf(2));
    activityItem3.setCategoryTo(String.valueOf(3));
    activityItem3.setId(2L);
    activityItem3.setCreatedDate("2020-04-07 12:30:32");
    activityItem3.setTaskTitle("swift 공부하기");

    ActivityItemDto activityItemDto1 = new ActivityItemDto(activityItem1);
    ActivityItemDto activityItemDto2 = new ActivityItemDto(activityItem2);
    ActivityItemDto activityItemDto3 = new ActivityItemDto(activityItem3);

    userActivityDtoList.add(activityItemDto1);
    userActivityDtoList.add(activityItemDto2);
    userActivityDtoList.add(activityItemDto3);

    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    response.setData(userActivityDtoList);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}

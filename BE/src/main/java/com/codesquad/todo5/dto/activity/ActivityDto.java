package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.Action;
import com.codesquad.todo5.domain.Activity;
import com.codesquad.todo5.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDto {
  private String userName;
  private String actionName;
  private Long categoryFrom;
  private Long categoryTo;
  private String createdTime;
  private String taskTitle;

  public ActivityDto(Activity item) {
    User user = item.getUser();
    Action action = item.getAction();
    this.userName = user.getUserName();
    this.actionName = action.getAction();
    this.categoryFrom = item.getCategoryFrom();
    this.categoryTo = item.getCategoryTo();
    this.createdTime = item.getCreatedDate();
    this.taskTitle = item.getTaskTitle();
  }
}
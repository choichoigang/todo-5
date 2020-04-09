package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.ActionItem;
import com.codesquad.todo5.domain.ActivityItem;
import com.codesquad.todo5.domain.UserItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityItemDto {
  private String userName;
  private String actionName;
  private String categoryFrom;
  private String categoryTo;
  private String createdTime;
  private String taskTitle;

  public ActivityItemDto(ActivityItem item) {
    UserItem userItem = item.getUserItem();
    ActionItem actionItem = item.getActionItem();
    this.userName = userItem.getUserName();
    this.actionName = actionItem.getAction();
    this.categoryFrom = item.getCategoryFrom();
    this.categoryTo = item.getCategoryTo();
    this.createdTime = item.getCreatedDate();
    this.taskTitle = item.getTaskTitle();
  }
}
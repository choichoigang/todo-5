package com.codesquad.todo5.dto.activity;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.user.User;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserActivityResponseDto {
  private String userName;
  private String action;
  private Long categoryFrom;
  private Long categoryTo;
  private Timestamp createdTime;
  private String taskTitle;

  public UserActivityResponseDto(Activity item, String userName) {
    this.userName = userName;
    Action action = item.getAction();
    this.action = action.getAction();
    this.categoryFrom = item.getCategoryFrom();
    this.categoryTo = item.getCategoryTo();
    this.createdTime = item.getCreatedDate();
  }
}
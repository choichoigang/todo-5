package com.codesquad.todo5.dto.activity;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDto {
  private String userName;
  private String action;
  private Long categoryFrom;
  private Long categoryTo;
  private String createdTime;
  private String taskTitle;

  public ActivityDto(Activity item) {
//    User user = item.getUser();
    Action action = item.getAction();
    this.categoryFrom = item.getCategoryFrom();
    this.categoryTo = item.getCategoryTo();
    this.createdTime = item.getCreatedDate();
  }
}
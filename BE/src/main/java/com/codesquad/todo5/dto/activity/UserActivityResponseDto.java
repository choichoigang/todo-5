package com.codesquad.todo5.dto.activity;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.Target;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserActivityResponseDto {
  private String userName;
  private String target;
  private String action;
  private Long categoryFrom;
  private Long categoryTo;
  private String createdTime;
  private String targetTitle;

  public UserActivityResponseDto(Activity item, String userName) {
    this.userName = userName;
    Target target = item.getTarget();
    this.target = target.getAction();
    Action action = item.getAction();
    this.action = action.getAction();
    this.categoryFrom = item.getCategoryFrom();
    this.categoryTo = item.getCategoryTo();
    this.createdTime = item.getCreatedDate();
    this.targetTitle = item.getTargetTitle();
  }
}
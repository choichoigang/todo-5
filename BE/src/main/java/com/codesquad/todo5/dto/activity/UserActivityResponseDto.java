package com.codesquad.todo5.dto.activity;

import com.codesquad.todo5.domain.activity.Activity;
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
    this.action = item.getAction();
    this.categoryFrom = item.getCategory_from();
    this.categoryTo = item.getCategory_to();
    this.createdTime = item.getCreated_date();
  }
}
package com.codesquad.todo5.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class ActivityItem {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Id
  private Long id;
  private UserItem userItem;
  private String createdDate;
  private ActionItem actionItem;
  private String categoryFrom;
  private String categoryTo;
  private String taskTitle;

  private ActivityItem(UserItem userItem, ActionItem actionItem) {
    this.userItem = userItem;
    this.createdDate = LocalDateTime.now().format(formatter);
    this.actionItem = actionItem;
  }

  public static ActivityItem create(UserItem userItem, ActionItem actionItem) {
    return new ActivityItem(userItem, actionItem);
  }

}

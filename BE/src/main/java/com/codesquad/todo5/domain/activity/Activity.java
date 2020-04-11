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
public class Activity {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Id
  private Long id;
  private User user;
  private String createdDate;
  private Action action;
  private Long categoryFrom;
  private Long categoryTo;
  private String taskTitle;

  private Activity(User user, Action action) {
    this.user = user;
    this.createdDate = LocalDateTime.now().format(formatter);
    this.action = action;
  }

  public static Activity create(User user, Action action) {
    return new Activity(user, action);
  }

}

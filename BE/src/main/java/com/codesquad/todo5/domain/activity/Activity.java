package com.codesquad.todo5.domain.activity;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("activity")
public class Activity {

  @Id
  private Long id;
  private User user;
  private Task task;
  private String createdDate;
  private Action action;
  private Long categoryFrom;
  private Long categoryTo;

  private Activity(User user, Action action) {
    this.user = user;
    this.action = action;
  }

  public static Activity create(User user, Action action) {
    return new Activity(user, action);
  }

}

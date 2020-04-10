package com.codesquad.todo5.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class TaskItem {

  @Id
  private Long id;
  private String title;
  @Length(max=500)
  private String content;
  private String userName;
  private boolean isDeleted;
  private int priority;
  private List<ActivityItem> Activity = new ArrayList<>();

  private TaskItem(String title, String content, String userName, int priority) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
    this.userName = userName;
    this.priority = priority;
  }

  public static TaskItem create(String title, String content, String userName, int priority) {
    return new TaskItem(title, content, userName, priority);
  }
}

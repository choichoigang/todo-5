package com.codesquad.todo5.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class TaskItem {

  @Id
  private Long id;
  private String title;
  private String content;
  private boolean isDeleted;
  private int priority;
  private List<ActivityItem> Activity = new ArrayList<>();

  private TaskItem(String title, String content) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
  }

  public static TaskItem create(String title, String content) {
    return new TaskItem(title, content);
  }
}

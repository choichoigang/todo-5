package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.TaskItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskItemDto {
  private String title;
  private String content;
  private String userName;
  private int priority;
  private Long id;

  public TaskItemDto(TaskItem item) {
    this.id = item.getId();
    this.title = item.getTitle();
    this.content = item.getContent();
    this.userName = item.getUserName();
    this.priority = item.getPriority();
  }
}

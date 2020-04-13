package com.codesquad.todo5.dto.task;

import com.codesquad.todo5.domain.task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskShowResponseDto {
  private String title;
  private String content;
  private String userName;
  private int priority;
  private Long categoryId;
//  private Long id;

  public TaskShowResponseDto(Task item) {
//    this.id = item.getId();
    this.title = item.getTitle();
    this.content = item.getContent();
    this.priority = item.getPriority();
  }

  public TaskShowResponseDto(String title, String content, String userName, int priority, Long categoryId) {
    this.title = title;
    this.content = content;
    this.userName = userName;
    this.priority = priority;
    this.categoryId = categoryId;
  }
}

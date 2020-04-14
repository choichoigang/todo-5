package com.codesquad.todo5.dto.task;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
public class TaskShowResponseDto {
  private Long id;
  private String title;
  private String content;
  private int priority;
  private String author;
  private int categoryFrom;
  private int categoryTo;
  private Long categoryNum;
  private boolean isDeleted;

  public TaskShowResponseDto(Long id, String title, String content, int priority, Long categoryNum, boolean isDeleted) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.priority = priority;
    this.categoryNum = categoryNum;
    this.isDeleted = isDeleted;
  }

  public TaskShowResponseDto(Long id, String title, String content, String author, int priority, Long categoryNum, boolean isDeleted) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
    this.priority = priority;
    this.categoryNum = categoryNum;
    this.isDeleted = isDeleted;
  }
}

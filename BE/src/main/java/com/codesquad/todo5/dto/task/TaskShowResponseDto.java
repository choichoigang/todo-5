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
  private Long taskId;
  private String title;
  private String content;
  private String userName;
  private int priority;
  private Long categoryId;

//  public TaskShowResponseDto(Task item, Long categoryId) {
////    this.id = item.getId();
//    this.title = item.getTitle();
//    this.content = item.getContent();
//    this.userName = taskRepository.findUserNameByTaskId(item.getId());
//    this.priority = item.getPriority();
//    this.categoryId = categoryId;
//  }
//
  public TaskShowResponseDto(Long taskId, String title, String content, int priority, Long categoryId) {
    this.taskId = taskId;
    this.title = title;
    this.content = content;
    this.priority = priority;
    this.categoryId = categoryId;
  }

  public TaskShowResponseDto(Long taskId, String title, String content, String userName, int priority, Long categoryId) {
    this.taskId = taskId;
    this.title = title;
    this.content = content;
    this.userName = userName;
    this.priority = priority;
    this.categoryId = categoryId;
  }
}

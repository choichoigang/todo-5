package com.codesquad.todo5.domain.task;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.dto.task.TaskEditDto;
import com.codesquad.todo5.exception.RudimentaryException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
@NoArgsConstructor
@Table("task")
public class Task {

  @Id
  private Long id;
  private String title;

  @Length(max=500)
  private String content;
  private String userName;
  private boolean isDeleted;
  private int priority;

  private Task(String title, String content, String userName, int priority) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
    this.userName = userName;
    this.priority = priority;
  }

  public static Task create(String title, String content, String userName, int priority) {
    return new Task(title, content, userName, priority);
  }

  public void updateTask(TaskEditDto dto) {
    updateTitle(dto);
    updateContent(dto);
    updatePriority(dto);
  }

  public void updateTitle(TaskEditDto dto) {
    if (ObjectUtils.isEmpty(dto.getTitle()) || this.title.equals(dto.getTitle())) {
      throw new RudimentaryException("무엇인가가 잘못되었습니다.");
    }
    this.title = dto.getTitle();
  }

  public void updateContent(TaskEditDto dto) {
    if (ObjectUtils.isEmpty(dto.getContent()) || this.content.equals(dto.getContent())) {
      throw new RudimentaryException("무엇인가가 잘못되었습니다.");
    }
    this.content = dto.getContent();
  }

  public void updatePriority(TaskEditDto dto) {
    if (ObjectUtils.isEmpty(dto.getPriority()) || this.priority == dto.getPriority()) {
      throw new RudimentaryException("무엇인가가 잘못되었습니다.");
    }
    this.content = dto.getContent();
  }
}
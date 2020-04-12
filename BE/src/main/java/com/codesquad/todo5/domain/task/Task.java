package com.codesquad.todo5.domain.task;

import com.codesquad.todo5.dto.task.TaskModifyRequestDto;
import com.codesquad.todo5.exception.RudimentaryException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
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
  private boolean isDeleted;
  private int priority;
//  @Column("category_from")
//  private int categoryFrom;
  @Column("category_to")
  private int categoryTo;

  private Task(String title, String content, int priority) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
    this.priority = priority;
  }

  public static Task create(String title, String content, int priority) {
    return new Task(title, content, priority);
  }

//  public void updateCategoryOrder(TaskEditRequestDto dto) {
//    if (ObjectUtils.isEmpty(dto.getCategoryFrom()) || ObjectUtils.isEmpty(dto.getCategoryTo())) {
//      throw new RudimentaryException("무엇인가가 잘못되었습니다.");
//    }
//    if (this.getCategoryFrom() == dto.getCategoryFrom() || this.getCategoryTo() == dto.getCategoryTo()) {
//      throw new RudimentaryException("무엇인가가 잘못되었습니다.");
//    }
//    this.categoryFrom = dto.getCategoryFrom();
//    this.categoryTo = dto.getCategoryTo();
//  }
}
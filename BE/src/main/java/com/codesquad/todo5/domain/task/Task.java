package com.codesquad.todo5.domain.task;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.dto.task.TaskModifyRequestDto;
import com.codesquad.todo5.exception.RudimentaryException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
@NoArgsConstructor
@Table("task")
public class Task implements Comparable<Task> {
//public class Task {
  @Id
  private Long id;
  private String title;

  @Length(max=500)
  private String content;
  private boolean isDeleted;

  @Column("priority")
  public int priority;
  @Column("author")
  private String author;
//  @Column("category_from")
//  private int categoryFrom;
//  @Column("category_key")
//  private int categoryKey;
  @Column("category_to")
  private Long categoryTo;

  public Task(String title, String content, int priority, String author) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
    this.priority = priority;
    this.author = author;
  }

  public static Task create(String title, String content, int priority, String author) {
    return new Task(title, content, priority, author);
  }

  @Override
  public int compareTo(Task task) {
    return this.priority - task.priority;
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
package com.codesquad.todo5.domain.task;

import com.codesquad.todo5.domain.user.User;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Task {

  @Id
  private Long id;
  @NotEmpty
  private String title;
  @NotEmpty
  @Length(max=500)
  private String content;
  private boolean isDeleted;
  private int priority;
  private int category_from;
  private int category_to;
  private int category_key;
  private Long user;
  private String author;

  private Task(String title, String content) {
    this.title = title;
    this.content = content;
    this.isDeleted = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    isDeleted = deleted;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public int getCategory_from() {
    return category_from;
  }

  public void setCategory_from(int category_from) {
    this.category_from = category_from;
  }

  public int getCategory_to() {
    return category_to;
  }

  public void setCategory_to(int category_to) {
    this.category_to = category_to;
  }

  public int getCategory_key() {
    return category_key;
  }

  public void setCategory_key(int category_key) {
    this.category_key = category_key;
  }

  public Long getUser() {
    return user;
  }

  public void setUser(Long user) {
    this.user = user;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setUser(User user) {
    this.user = user.getId();
    this.author = user.getName();
  }
}

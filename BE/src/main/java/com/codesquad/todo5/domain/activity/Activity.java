package com.codesquad.todo5.domain.activity;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.user.User;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Activity {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Id
  private int id;
  private Timestamp created_date;
  private String action;
  private Long category_from;
  private Long category_to;
  private int board_key;
  private Long user;
  private String author;
  private String task; //category도 지원할 수 있도록 해주어야 한다. 어떻게 할 수 있을 지 고민이다.

  public Activity(ActionItem action, Category category_from, Category category_to, Task task, User user) {
    this.action = action.getAction();
    this.category_from = category_from.getId();
    this.category_to = category_to.getId();
    this.task = task.getTitle();
    this.user = user.getId();
    this.author = user.getName();
  }

  public DateTimeFormatter getFormatter() {
    return formatter;
  }

  public void setFormatter(DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Timestamp getCreated_date() {
    return created_date;
  }

  public void setCreated_date(Timestamp created_date) {
    this.created_date = created_date;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public void setCategory_from(Long category_from) {
    this.category_from = category_from;
  }

  public void setCategory_to(Long category_to) {
    this.category_to = category_to;
  }

  public int getBoard_key() {
    return board_key;
  }

  public void setBoard_key(int board_key) {
    this.board_key = board_key;
  }

  public Long getCategory_from() {
    return category_from;
  }

  public Long getCategory_to() {
    return category_to;
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

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}

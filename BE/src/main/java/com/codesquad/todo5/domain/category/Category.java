package com.codesquad.todo5.domain.category;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.user.User;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Category {

  @Id
  private Long id;
  private String name;
  private List<Task> task;
  private boolean isDeleted;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Task> getTask() {
    return task;
  }

  public void setTask(List<Task> task) {
    this.task = task;
  }

  public Task getNewTask() {
    return task.get(0);
  }

  public void addTask(Task newTask, User user, int priority) {
    newTask.setUser(user);
    this.task.add(priority, newTask);
  }
}

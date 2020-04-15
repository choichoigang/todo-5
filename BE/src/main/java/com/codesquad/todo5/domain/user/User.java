package com.codesquad.todo5.domain.user;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.task.Task;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("user")
public class User {

  @Id
  private Long id;
  private String name;
  private String password;
  private List<Task> task = new ArrayList<>();

  @MappedCollection(idColumn="user", keyColumn="user_key")
  private List<Activity> activity = new ArrayList<>();

  private User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public void addTask(Task newTask) {
    task.add(newTask);
  }

  public static User create(String name, String password) {
    return new User(name, password);
  }

  public boolean isMatchWithUserName(String userName) {
    return this.name.equals(userName);
  }
}

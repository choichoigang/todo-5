package com.codesquad.todo5.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class UserItem {

  @Id
  private Long id;
  private String name;
  private String password;
  private List<TaskItem> task = new ArrayList<>();

  UserItem(String name, String password) {
    this.name = name;
    this.password = password;
  }

  private static UserItem create(String name, String password) {
    return new UserItem(name, password);
  }

}

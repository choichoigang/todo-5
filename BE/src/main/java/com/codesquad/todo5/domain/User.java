package com.codesquad.todo5.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  private Long id;
  private String name;
  private String password;
  private List<ActionItem> Activity = new LinkedList<>();

  User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  private static User create(String name, String password) {
    return new User(name, password);
  }

}

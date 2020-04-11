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
public class User {

  @Id
  private Long id;
  private String userName;
  private List<Task> task = new ArrayList<>();

  private User(String userName) {
    this.userName = userName;
  }

  public static User create(String userName) {
    return new User(userName);
  }

}

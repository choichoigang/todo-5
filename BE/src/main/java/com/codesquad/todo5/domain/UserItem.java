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
  private String userName;
  private List<TaskItem> task = new ArrayList<>();

  private UserItem(String userName) {
    this.userName = userName;
  }

  public static UserItem create(String userName) {
    return new UserItem(userName);
  }

}

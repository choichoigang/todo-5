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
public class Category {

  @Id
  private Long id;
  private String name;
  private List<TaskItem> task = new ArrayList<>();

  private Category(String name) {
    this.name = name;
  }

  public static Category create(String name) {
    return new Category(name);
  }
}

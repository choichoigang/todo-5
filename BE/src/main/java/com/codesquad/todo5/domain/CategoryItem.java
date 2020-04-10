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
public class CategoryItem {

  @Id
  private Long id;
  private String name;
  private boolean isDeleted;
  private List<TaskItem> task = new ArrayList<>();

  private CategoryItem(String name) {
    this.name = name;
  }

  public static CategoryItem create(String name) {
    return new CategoryItem(name);
  }
}

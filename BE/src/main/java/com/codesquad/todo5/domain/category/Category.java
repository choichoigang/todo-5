package com.codesquad.todo5.domain.category;

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
public class Category {

  @Id
  private Long id;
  private String name;
  private boolean isDeleted;

  //@MappedCollection(idColumn = "category_id", keyColumn = "category_key")
  private List<Task> task = new ArrayList<>();

  private Category(String name) {
    this.name = name;
  }

  public static Category create(String name) {
    return new Category(name);
  }

  public void addTask(Task task) {
    this.task.add(task);
  }

  public void moveTask(int previousPriority, int newPriority) { //change the priority
    this.task.get(previousPriority).setPriority(newPriority);
  }
}

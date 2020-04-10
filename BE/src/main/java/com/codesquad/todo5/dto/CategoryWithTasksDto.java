package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.CategoryItem;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryWithTasksDto {
  private Long id;
  private String name;
  private List<TaskItemDto> taskItemDtoList;

  public CategoryWithTasksDto(CategoryItem item) {
    this.id = item.getId();
    this.name = item.getName();
    this.taskItemDtoList = item.getTask().stream()
        .map(taskitem -> new TaskItemDto(taskitem))
        .collect(Collectors.toList());
  }


}

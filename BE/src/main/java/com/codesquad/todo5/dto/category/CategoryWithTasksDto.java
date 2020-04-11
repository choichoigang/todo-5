package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.Category;
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
  private List<TaskResponseDto> taskResponseDtoList;

  public CategoryWithTasksDto(Category item) {
    this.id = item.getId();
    this.name = item.getName();
    this.taskResponseDtoList = item.getTask().stream()
        .map(taskitem -> new TaskResponseDto(taskitem))
        .collect(Collectors.toList());
  }


}

package com.codesquad.todo5.dto.category;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.dto.task.TaskShowResponseDto;
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
  private List<TaskShowResponseDto> taskResponseDtoList;

  public CategoryWithTasksDto(Category item) {
    this.id = item.getId();
    this.name = item.getName();
    this.taskResponseDtoList = item.getTask().stream()
        .map(taskitem -> new TaskShowResponseDto(taskitem))
        .collect(Collectors.toList());
  }


}

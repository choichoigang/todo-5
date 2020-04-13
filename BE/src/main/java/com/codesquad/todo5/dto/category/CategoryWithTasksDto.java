package com.codesquad.todo5.dto.category;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.dto.task.TaskShowResponseDto;
import java.util.List;
import java.util.stream.Collectors;

import com.codesquad.todo5.exception.ResourceNotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryWithTasksDto {
  private Long categoryId;
  private String categoryName;
  private List<TaskShowResponseDto> taskResponseDtoList;

  public CategoryWithTasksDto(Category category) {
    this.categoryId = category.getId();
    this.categoryName = category.getName();
    this.taskResponseDtoList = category.getTask().stream()
        .map(taskItem -> new TaskShowResponseDto(taskItem.getId(), taskItem.getTitle(), taskItem.getContent(), taskItem.getPriority(), this.categoryId))
        .collect(Collectors.toList());
  }
}

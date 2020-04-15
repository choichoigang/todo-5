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
  private List<TaskShowResponseDto> task;

  public CategoryWithTasksDto(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.task = category.getTask().stream()
        .map(taskItem -> new TaskShowResponseDto(taskItem.getId(), taskItem.getTitle(), taskItem.getContent(), taskItem.getPriority(), this.id, taskItem.isDeleted()))
        .collect(Collectors.toList());
  }

  public CategoryWithTasksDto(Category category, List<TaskShowResponseDto> dto) {
    this.id = category.getId();
    this.name = category.getName();
    this.task = dto;
  }
}
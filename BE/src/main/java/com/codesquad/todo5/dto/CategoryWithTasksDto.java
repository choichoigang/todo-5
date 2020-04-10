package com.codesquad.todo5.dto;

import java.util.List;
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
}

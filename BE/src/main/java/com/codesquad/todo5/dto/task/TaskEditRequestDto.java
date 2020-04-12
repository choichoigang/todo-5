package com.codesquad.todo5.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEditRequestDto {
  private String title;
  private String content;
  private int priority;
  private int categoryFrom;
  private int categoryTo;
}

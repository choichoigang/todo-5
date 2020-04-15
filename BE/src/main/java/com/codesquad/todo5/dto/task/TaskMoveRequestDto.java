package com.codesquad.todo5.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskMoveRequestDto {
  private int priority;
  //    private int categoryFrom;
  private int categoryTo;
}

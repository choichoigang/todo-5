package com.codesquad.todo5.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequestDto {
  private String title;
  private String content;
  private String author;
  private Long categoryNum;
  private Long categoryFrom;
  private Long categoryTo;
}

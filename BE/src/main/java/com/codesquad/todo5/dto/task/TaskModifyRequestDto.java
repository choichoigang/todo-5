package com.codesquad.todo5.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskModifyRequestDto {
  private String modifiedTitle;
  private String modifiedContent;
}

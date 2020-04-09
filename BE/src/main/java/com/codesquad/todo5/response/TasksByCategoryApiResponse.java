package com.codesquad.todo5.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TasksByCategoryApiResponse {
  private Object status;
  private Object data;
  private String categoryName;
  private Long categoryId;

  public TasksByCategoryApiResponse(Object status, Object data, String categoryName, Long categoryId) {
    this.status = status;
    this.data = data;
    this.categoryName = categoryName;
    this.categoryId = categoryId;
  }

}

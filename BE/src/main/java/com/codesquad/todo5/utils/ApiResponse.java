package com.codesquad.todo5.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
  private Object status;
  private Object data;

  public ApiResponse(Object status, Object data) {
    this.status = status;
    this.data = data;
  }

}

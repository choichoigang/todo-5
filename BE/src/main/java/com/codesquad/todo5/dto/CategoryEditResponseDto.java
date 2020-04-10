package com.codesquad.todo5.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryEditResponseDto {
  public String status;
  public String data;

  public CategoryEditResponseDto(String status, String data) {
    this.status = status;
    this.data = data;
  }

  public static CategoryEditResponseDto create(boolean status, String data) {
    return new CategoryEditResponseDto(status, data);
  }
}

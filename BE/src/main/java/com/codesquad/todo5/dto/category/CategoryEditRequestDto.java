package com.codesquad.todo5.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEditRequestDto {
  private String name;
  public boolean isDeleted;

  public boolean isDeleted() {
    return isDeleted;
  }
}

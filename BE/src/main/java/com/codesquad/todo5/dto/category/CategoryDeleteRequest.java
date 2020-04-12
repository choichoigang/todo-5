package com.codesquad.todo5.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDeleteRequest {
  public boolean isDeleted;
  //TODO CategoryEditRequest로 CategoryNameEditRequest와 CategoryDeleteRequest를 통합하는 방안 생각해보기
}

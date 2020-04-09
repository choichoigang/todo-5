package com.codesquad.todo5.dto;

import com.codesquad.todo5.domain.CategoryItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryItemDto {
  private Long id;
  private String name;

  public CategoryItemDto(CategoryItem item) {
    this.id = item.getId();
    this.name = item.getName();
  }
}

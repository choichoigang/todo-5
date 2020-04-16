package com.codesquad.todo5.domain.activity;
import com.codesquad.todo5.utils.EnumType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Target implements EnumType {
  TASK("태스크"),
  CATEGORY("카테고리");

  private final String action;

  public String getAction() {
    return action;
  }

  @Override
  public String getId() {
    return this.name();
  }
}

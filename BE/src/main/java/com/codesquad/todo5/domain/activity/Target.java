package com.codesquad.todo5.domain.activity;
import com.codesquad.todo5.utils.EnumType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Target implements EnumType {
  TASK("TASK"),
  CATEGORY("CATEGORY");

  private final String action;

  public String getAction() {
    return action;
  }

  @Override
  public String getId() {
    return this.name();
  }
}

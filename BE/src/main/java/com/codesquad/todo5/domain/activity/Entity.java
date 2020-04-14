package com.codesquad.todo5.domain.activity;

import com.codesquad.todo5.utils.EnumType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Entity implements EnumType {
  TASK("TASK"),
  CATEGORY("CATEGORY"),
  USER("USER");

  private final String action;

  public String getAction() {
    return action;
  }

  @Override
  public String getId() {
    return this.name();
  }
}

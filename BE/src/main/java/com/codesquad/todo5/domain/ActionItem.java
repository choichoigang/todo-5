package com.codesquad.todo5.domain;

import com.codesquad.todo5.utils.EnumType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActionItem implements EnumType {
  ADD("ADD"),
  REMOVE("REMOVE"),
  UPDATE("UPDATE"),
  MOVE("MOVE");

  private final String text;

  @Override
  public String getId() {
    return this.name();
  }
}

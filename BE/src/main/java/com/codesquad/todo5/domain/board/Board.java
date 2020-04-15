package com.codesquad.todo5.domain.board;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.user.User;
import java.util.List;
import org.springframework.data.annotation.Id;

public class Board {
  @Id
  private Long id;
  private String name;
  private List<Category> category;
  private List<Activity> activity;
  private List<User> user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Category> getCategory() {
    return category;
  }

  public void setCategory(List<Category> category) {
    this.category = category;
  }

  public List<Activity> getActivity() {
    return activity;
  }

  public void setActivity(List<Activity> activity) {
    this.activity = activity;
  }

  public List<User> getUser() {
    return user;
  }

  public void setUser(List<User> user) {
    this.user = user;
  }

  public void addActivity(Activity activity) {
    //맨 처음에 항상 삽입해준다.
    this.activity.add(0, activity);
  }
}

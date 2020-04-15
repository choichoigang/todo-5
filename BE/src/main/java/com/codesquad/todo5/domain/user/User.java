package com.codesquad.todo5.domain.user;

import com.codesquad.todo5.domain.activity.ActionItem;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;

    public void setId(Long id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Long getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public boolean checkName(String inputName) {
      return this.name.equals(inputName);
    }
}

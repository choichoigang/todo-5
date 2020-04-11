package com.codesquad.todo5.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

  List<Activity> findAllActivityByUserId(String author);
}

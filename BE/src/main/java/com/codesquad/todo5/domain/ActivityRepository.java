package com.codesquad.todo5.domain;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<ActivityItem, Long> {

  @Query("SELECT * FROM activity a WHERE")
  List<ActivityItem> findAllActivityByUserId(String author);
}

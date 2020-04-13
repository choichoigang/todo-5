package com.codesquad.todo5.domain.activity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

  @Query("SELECT * FROM activity WHERE user = :userId ORDER BY created_date DESC")
  Optional<List<Activity>> findAllActivityByUserId(Long userId);
}
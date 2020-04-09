package com.codesquad.todo5.domain;

import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<ActivityItem, Long> {

}

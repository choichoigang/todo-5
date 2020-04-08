package com.codesquad.todo5.domain;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskItem, Long> {

}

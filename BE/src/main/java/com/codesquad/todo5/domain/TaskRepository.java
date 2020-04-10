package com.codesquad.todo5.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskItem, Long> {

  List<TaskItem> findAll();
}
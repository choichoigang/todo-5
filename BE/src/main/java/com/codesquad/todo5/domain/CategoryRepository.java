package com.codesquad.todo5.domain;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryItem, Long> {

  @Query("SELECT c.id, c.name, c.created_date_time FROM category c")
  List<CategoryItem> findAllCategoryItems();
}

package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.CategoryItem;
import com.codesquad.todo5.domain.TaskItem;
import com.codesquad.todo5.domain.UserItem;
import com.codesquad.todo5.dto.TaskItemDto;
import com.codesquad.todo5.dto.CategoryWithTasksDto;
import com.codesquad.todo5.utils.ApiResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CategoryController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @GetMapping("/category/all")
  public String showAllCategoryItem() {
    return "{\n"
        + "\t\"status\": true,\n"
        + "\t\"data\": [{\n"
        + "\t\t\t\"id\": 1,\n"
        + "\t\t\t\"name\": \"todo\",\n"
        + "\t\t\t\"tasks\": [{\n"
        + "\t\t\t\t\t\"title\": \"github 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"호눅스 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 1,\n"
        + "\t\t\t\t\t\"id\": 1\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"swift 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"JK 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 2,\n"
        + "\t\t\t\t\t\"id\": 2\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"java 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"pobi 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 3,\n"
        + "\t\t\t\t\t\"id\": 3\n"
        + "\t\t\t\t}\n"
        + "\t\t\t]\n"
        + "\t\t},\n"
        + "\t\t{\n"
        + "\t\t\t\"id\": 2,\n"
        + "\t\t\t\"name\": \"doing\",\n"
        + "\t\t\t\"tasks\": [{\n"
        + "\t\t\t\t\t\"title\": \"github 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"호눅스 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 1,\n"
        + "\t\t\t\t\t\"id\": 1\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"swift 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"JK 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 2,\n"
        + "\t\t\t\t\t\"id\": 2\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"java 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"pobi 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 3,\n"
        + "\t\t\t\t\t\"id\": 3\n"
        + "\t\t\t\t}\n"
        + "\t\t\t]\n"
        + "\t\t},\n"
        + "\t\t{\n"
        + "\t\t\t\"id\": 3,\n"
        + "\t\t\t\"name\": \"done\",\n"
        + "\t\t\t\"tasks\": [{\n"
        + "\t\t\t\t\t\"title\": \"github 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"호눅스 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 1,\n"
        + "\t\t\t\t\t\"id\": 1\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"swift 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"JK 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 2,\n"
        + "\t\t\t\t\t\"id\": 2\n"
        + "\t\t\t\t},\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t\"title\": \"java 공부하기\",\n"
        + "\t\t\t\t\t\"content\": \"pobi 짱짱맨이에요.\",\n"
        + "\t\t\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\t\t\"priority\": 3,\n"
        + "\t\t\t\t\t\"id\": 3\n"
        + "\t\t\t\t}\n"
        + "\t\t\t]\n"
        + "\t\t}\n"
        + "\t]\n"
        + "}";
//    //basic setting
//    CategoryItem todo = CategoryItem.create("todo");
//    todo.setId(1L);
//    CategoryItem doing = CategoryItem.create("doing");
//    doing.setId(2L);
//    CategoryItem done = CategoryItem.create("done");
//    done.setId(3L);
//    UserItem testUser = UserItem.create("crongro");
//    TaskItem taskItem = TaskItem.create("github 공부하기", "호눅스 짱짱맨이에요.", testUser.getUserName(), 1);
//    taskItem.setId(1L);
//    TaskItem taskItem2 = TaskItem.create("swift 공부하기", "JK 짱짱맨이에요.", testUser.getUserName(), 2);
//    taskItem2.setId(2L);
//    TaskItem taskItem3 = TaskItem.create("java 공부하기", "pobi 짱짱맨이에요.", testUser.getUserName(), 3);
//    taskItem3.setId(3L);
//
//    List<TaskItem> todoItemList = new ArrayList<>();
//    todoItemList.add(taskItem);
//    todoItemList.add(taskItem2);
//    todoItemList.add(taskItem3);
//    todo.setTask(todoItemList);
//
//    List<TaskItemDto> tasks =
//        todo.getTask().stream().map(taskitem -> new TaskItemDto(taskitem))
//            .collect(Collectors.toList());
//
//    CategoryWithTasksDto categoryWithTasksDto1 = new CategoryWithTasksDto();
//    categoryWithTasksDto1.setTaskItemDtoList(tasks);
//    categoryWithTasksDto1.setId(todo.getId());
//    categoryWithTasksDto1.setName(todo.getName());
//
//    CategoryWithTasksDto categoryWithTasksDto2 = new CategoryWithTasksDto();
//    categoryWithTasksDto2.setTaskItemDtoList(tasks);
//    categoryWithTasksDto2.setId(doing.getId());
//    categoryWithTasksDto2.setName(doing.getName());
//
//    CategoryWithTasksDto categoryWithTasksDto3 = new CategoryWithTasksDto();
//    categoryWithTasksDto3.setTaskItemDtoList(tasks);
//    categoryWithTasksDto3.setId(done.getId());
//    categoryWithTasksDto3.setName(done.getName());
//
//    List<CategoryWithTasksDto> tasks1 = new ArrayList<>();
//    tasks1.add(categoryWithTasksDto1);
//    tasks.add(categoryWithTasksDto2);
//    tasks.add(categoryWithTasksDto3);
//
//    ApiResponse response = new ApiResponse();
//    response.setStatus(true);
//    response.setData(tasks);
//
//    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/all")
  public String showAllTaskItemsByCategoryNum(@PathVariable int num) {
//    logger.debug("Number of category: {}", num);
//    //basic setting
//    UserItem testUser = UserItem.create("crongro");
//    CategoryItem todo = CategoryItem.create("오늘의 할 일");
//    TaskItem taskItem = TaskItem.create("github 공부하기", "호눅스 짱짱맨이에요.", testUser.getUserName(), 1);
//    taskItem.setId(1L);
//    TaskItem taskItem2 = TaskItem.create("swift 공부하기", "JK 짱짱맨이에요.", testUser.getUserName(), 2);
//    taskItem2.setId(2L);
//    TaskItem taskItem3 = TaskItem.create("java 공부하기", "pobi 짱짱맨이에요.", testUser.getUserName(), 3);
//    taskItem3.setId(3L);
//
//    List<TaskItem> todoItemList = new ArrayList<>();
//    todoItemList.add(taskItem);
//    todoItemList.add(taskItem2);
//    todoItemList.add(taskItem3);
//    todo.setTask(todoItemList);
//
//    //dto setting
//    List<TaskItemDto> tasks =
//        todo.getTask().stream().map(taskitem -> new TaskItemDto(taskitem))
//            .collect(Collectors.toList());
//
//    TasksByCategoryApiResponse response = new TasksByCategoryApiResponse();
//    response.setStatus(true);
//    response.setData(tasks);
//    response.setCategoryName("todo");
//    response.setCategoryId(1L);
//
//    return new ResponseEntity<>(response, HttpStatus.OK);
    return "{\n"
        + "\t\"status\": true,\n"
        + "\t\"data\": [{\n"
        + "\t\t\t\"title\": \"github 공부하기\",\n"
        + "\t\t\t\"content\": \"호눅스 짱짱맨이에요.\",\n"
        + "\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\"priority\": 1,\n"
        + "\t\t\t\"id\": 1\n"
        + "\t\t},\n"
        + "\t\t{\n"
        + "\t\t\t\"title\": \"swift 공부하기\",\n"
        + "\t\t\t\"content\": \"JK 짱짱맨이에요.\",\n"
        + "\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\"priority\": 2,\n"
        + "\t\t\t\"id\": 2\n"
        + "\t\t},\n"
        + "\t\t{\n"
        + "\t\t\t\"title\": \"java 공부하기\",\n"
        + "\t\t\t\"content\": \"pobi 짱짱맨이에요.\",\n"
        + "\t\t\t\"userName\": \"crongro\",\n"
        + "\t\t\t\"priority\": 3,\n"
        + "\t\t\t\"id\": 3\n"
        + "\t\t}\n"
        + "\t],\n"
        + "\t\"categoryName\": \"todo\",\n"
        + "\t\"categoryId\": 1\n"
        + "}";
  }

  @GetMapping("/category/add")
  public ResponseEntity<ApiResponse> addCategoryItem() {
    ApiResponse response = new ApiResponse();
    response.setStatus(true);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCategoryItem(@PathVariable int num) {
    logger.debug("Number of category: {}", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
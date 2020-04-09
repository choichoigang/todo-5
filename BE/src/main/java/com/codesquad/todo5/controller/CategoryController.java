package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.CategoryItem;
import com.codesquad.todo5.domain.TaskItem;
import com.codesquad.todo5.domain.UserItem;
import com.codesquad.todo5.dto.CategoryItemDto;
import com.codesquad.todo5.dto.TaskItemDto;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.response.TasksByCategoryApiResponse;
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
    return
        "{\n"
            + "  \"status\": true,\n"
            + "  \"data\": [\n"
            + "    {\n"
            + "      \"id\": 1,\n"
            + "      \"name\": \"todo\"\n"
            + "      \"tasks\": [\n"
            + "        {\n"
            + "          \"title\": \"github 공부하기\",\n"
            + "          \"content\": \"호눅스 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 1,\n"
            + "          \"id\": 1\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"swift 공부하기\",\n"
            + "          \"content\": \"JK 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 2,\n"
            + "          \"id\": 2\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"java 공부하기\",\n"
            + "          \"content\": \"pobi 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 3,\n"
            + "          \"id\": 3\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 2,\n"
            + "      \"name\": \"doing\"\n"
            + "      \"tasks\": [\n"
            + "        {\n"
            + "          \"title\": \"github 공부하기\",\n"
            + "          \"content\": \"호눅스 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 1,\n"
            + "          \"id\": 1\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"swift 공부하기\",\n"
            + "          \"content\": \"JK 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 2,\n"
            + "          \"id\": 2\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"java 공부하기\",\n"
            + "          \"content\": \"pobi 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 3,\n"
            + "          \"id\": 3\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 3,\n"
            + "      \"name\": \"done\"\n"
            + "      \"tasks\": [\n"
            + "        {\n"
            + "          \"title\": \"github 공부하기\",\n"
            + "          \"content\": \"호눅스 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 1,\n"
            + "          \"id\": 1\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"swift 공부하기\",\n"
            + "          \"content\": \"JK 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 2,\n"
            + "          \"id\": 2\n"
            + "        },\n"
            + "        {\n"
            + "          \"title\": \"java 공부하기\",\n"
            + "          \"content\": \"pobi 짱짱맨이에요.\",\n"
            + "          \"userName\": \"crongro\",\n"
            + "          \"priority\": 3,\n"
            + "          \"id\": 3\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
  }

  @GetMapping("/category/{num}/all")
  public ResponseEntity<TasksByCategoryApiResponse> showAllTaskItemsByCategoryNum(@PathVariable int num) {
    logger.debug("Number of category: {}", num);
    //basic setting
    UserItem testUser = UserItem.create("crongro");
    CategoryItem todo = CategoryItem.create("오늘의 할 일");
    TaskItem taskItem = TaskItem.create("github 공부하기", "호눅스 짱짱맨이에요.", testUser.getUserName(), 1);
    taskItem.setId(1L);
    TaskItem taskItem2 = TaskItem.create("swift 공부하기", "JK 짱짱맨이에요.", testUser.getUserName(), 2);
    taskItem2.setId(2L);
    TaskItem taskItem3 = TaskItem.create("java 공부하기", "pobi 짱짱맨이에요.", testUser.getUserName(), 3);
    taskItem3.setId(3L);

    List<TaskItem> todoItemList = new ArrayList<>();
    todoItemList.add(taskItem);
    todoItemList.add(taskItem2);
    todoItemList.add(taskItem3);
    todo.setTask(todoItemList);

    //dto setting
    List<TaskItemDto> taskItemDtoList =
        todo.getTask().stream().map(taskitem -> new TaskItemDto(taskitem))
            .collect(Collectors.toList());

    TasksByCategoryApiResponse response = new TasksByCategoryApiResponse();
    response.setStatus(true);
    response.setData(taskItemDtoList);
    response.setCategoryName("todo");
    response.setCategoryId(1L);

    return new ResponseEntity<>(response, HttpStatus.OK);
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
package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.CategoryItem;
import com.codesquad.todo5.domain.CategoryRepository;
import com.codesquad.todo5.dto.CategoryEditResponseDto;
import com.codesquad.todo5.dto.CategoryWithTasksDto;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import com.codesquad.todo5.exception.RudimentaryException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public List<CategoryWithTasksDto> findAllDesc() {
    return categoryRepository.findAllDesc().stream()
        .map(element -> new CategoryWithTasksDto(element))
        .collect(Collectors.toList());
  }

  @Transactional
  public CategoryEditResponseDto save() {
    if (!categoryRepository.addItem()) {
      throw new RudimentaryException("알 수 없는 오류가 발생했습니다.");
    }
    return CategoryEditResponseDto.create(true, null);
  }

  @Transactional
  public CategoryEditResponseDto delete(Long Id) {
    if (checkValidity(Id)) {
      categoryRepository.deleteById(Id);
    }
    throw new RudimentaryException("알 수 없는 오류가 발생했습니다.");
  }

  private boolean checkValidity(Long Id) {
    CategoryItem item = categoryRepository.findById(Id).orElseThrow(
        () -> new ResourceNotFoundException());
    if (item.isDeleted()) {
      throw new ResourceNotFoundException();
    }
    return true;
  }
}
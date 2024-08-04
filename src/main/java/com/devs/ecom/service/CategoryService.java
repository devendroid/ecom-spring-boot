package com.devs.ecom.service;

import java.util.List;

import com.devs.ecom.entity.Category;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    String updateCategory(Category category, Long categoryId);

}

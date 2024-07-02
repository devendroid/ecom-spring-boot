package com.devs.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs.ecom.model.Category;
import com.devs.ecom.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

   @Autowired
   private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Optional<Category> optionalCat =  categoryRepository.findById(categoryId);

        Category savedCat = optionalCat.orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")
        );

        categoryRepository.delete(savedCat);

        return "Deleted category id " + categoryId;
    }

    @Override
    public String updateCategory(Category category, Long categoryId) {

        Optional<Category> optionalCat =  categoryRepository.findById(categoryId);

        optionalCat.orElseThrow(() -> 
            new  ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")
        );

        category.setCategoryId(categoryId);

        categoryRepository.save(category);

        return "Updated category id " + categoryId;

    }

}

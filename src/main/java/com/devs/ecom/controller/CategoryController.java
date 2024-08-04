package com.devs.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devs.ecom.entity.Category;
import com.devs.ecom.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // OR

    // public CategoryController(CategoryService categoryService) {
    // this.categoryService = categoryService;
    // }

    // @RequestMapping(path = "/public/categories", method = RequestMethod.GET)
    // OR
    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/admin/createCategory")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return ResponseEntity.ok("Category added sucessfully");
    }

    @DeleteMapping("/admin/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String message = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(message, HttpStatus.OK);
            // OR
            //return ResponseEntity.status(HttpStatus.OK).body(message);
            // OR
            //return ResponseEntity.ok(message);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/updateCategory/{categoryId}")
    public ResponseEntity<String> updateCategory(
        @RequestBody Category category,
     @PathVariable Long categoryId) {

        try {
            String message = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}

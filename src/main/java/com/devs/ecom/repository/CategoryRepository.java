package com.devs.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.ecom.entity.Category;

// public interface CategoryRepository extends CrudRepository{   OR
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

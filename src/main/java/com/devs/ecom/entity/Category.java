package com.devs.ecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    // public Category(Long categoryId, String categoryName) {
    //     this.categoryId = categoryId;
    //     this.categoryName = categoryName;
    // }

    // public Category() {
    // }
    
    // public Long getCategoryId() {
    //     return categoryId;
    // }
    // public void setCategoryId(Long categoryId) {
    //     this.categoryId = categoryId;
    // }
    // public String getCategoryName() {
    //     return categoryName;
    // }
    // public void setCategoryName(String categoryname) {
    //     this.categoryName = categoryname;
    // }
}

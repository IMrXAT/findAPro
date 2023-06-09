package com.example.findapro.core.category;

import com.example.findapro.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findCategoryByCategoryName(String name);
    List<Category> findByCategoryGroupGroupName(String categoryGroupName);
}

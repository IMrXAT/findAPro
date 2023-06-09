package com.example.findapro.core.category;

import com.example.findapro.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    private final CategoryRepository categoryRepository;
    public CategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesInCategoryGroup(String categoryGroupName){
        return categoryRepository.findByCategoryGroupGroupName(categoryGroupName);
    }


}

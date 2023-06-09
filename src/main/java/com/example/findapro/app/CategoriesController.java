package com.example.findapro.app;

import com.example.findapro.core.category.CategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public String allCategories(Model model){
        model.addAttribute("categories", categoriesService.getCategories());
        return "categories";
    }

    @GetMapping("/group/categories")
    public String categoriesInGroup(Model model){
        model.addAttribute("categories", categoriesService.getCategoriesInCategoryGroup("лабы по проге"));
        return "categories_in_group";
    }
}

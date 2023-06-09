package com.example.findapro.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

    @Entity
    @Table(name = "categories")
    public class Category {
        @Id @GeneratedValue
        private Long id;
        @Column(name = "category_name")
        String categoryName;

        @ManyToOne
        @JoinColumn(name = "category_group_id")
        private CategoryGroup categoryGroup;

        @OneToMany
        @JoinColumn(name = "category_id")
        private List<Task> tasks;



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryGroup getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }
}

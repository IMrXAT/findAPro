package com.example.findapro.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categories")
public class Category {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private CategoryGroup categoryGroup;

    @OneToMany
    private Collection<Task> tasks;

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
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

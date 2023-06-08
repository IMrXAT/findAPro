package com.example.findapro.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category_groups")
public class CategoryGroup {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "group_name")
    private String groupName;
    @OneToMany(mappedBy = "categoryGroup")
    private List<Category> categories;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

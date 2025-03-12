package org.example.persistence.entity;

public class CategoryEntity {

    private int id_category;
    private String category_name;

    public CategoryEntity(String category_name) {
        this.category_name = category_name;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}

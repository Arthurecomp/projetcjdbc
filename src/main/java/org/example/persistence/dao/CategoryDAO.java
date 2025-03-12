package org.example.persistence.dao;

import org.example.persistence.config.ConnectionUtil;
import org.example.persistence.entity.CategoryEntity;

import java.sql.SQLException;

public class CategoryDAO {

    public void insert(CategoryEntity category) {
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement("INSERT INTO category (category_name) VALUES (?)")) {
            statement.setString(1, category.getCategory_name());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.createStatement()){
            var sql = "DELETE FROM user WHERE id_category = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.persistence.dao;

import org.example.persistence.config.ConnectionUtil;
import org.example.persistence.entity.TaskEntity;

import java.sql.SQLException;

public class TaskDAO {
    public void insert(TaskEntity task) {
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement("INSERT INTO task (title, description,status,due_date,id_user,id_category) VALUES (?,?,?,?,?,?)")) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStatus());
            statement.setString(4, task.getDueDate());
            statement.setInt(5,task.getUserId());
            statement.setInt(6,task.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.createStatement()){
            var sql = "DELETE FROM task WHERE id_task = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

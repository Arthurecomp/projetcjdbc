package org.example.persistence.dao;


import org.example.persistence.config.ConnectionUtil;
import org.example.persistence.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void insert(UserEntity user) {
        try(var connection = ConnectionUtil.getConnection();
        var statement = connection.prepareStatement("INSERT INTO user (username, email) VALUES (?, ?)")) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id){
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.createStatement()){
            var sql = "DELETE FROM user WHERE id_user = " + id;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserEntity findByName(String name) {
        String sql = "SELECT id_user, username, email FROM user WHERE username = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId_user(resultSet.getInt("id_user"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage(), e);
        }
        return null;
    }

}

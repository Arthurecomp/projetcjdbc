package org.example;

import jdk.jfr.Category;
import org.example.persistence.dao.CategoryDAO;
import org.example.persistence.dao.TaskDAO;
import org.example.persistence.dao.UserDAO;
import org.example.persistence.entity.CategoryEntity;
import org.example.persistence.entity.TaskEntity;
import org.example.persistence.entity.UserEntity;
import org.example.ui.Menu;
import org.flywaydb.core.Flyway;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/projetojdbc", "root", "senha73642")
                .load();
        flyway.migrate();
        Menu menu = new Menu();
        menu.execute();
    }
}
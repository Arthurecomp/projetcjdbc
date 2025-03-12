CREATE TABLE task (
                      id_task INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      description TEXT,
                      status VARCHAR(20) NOT NULL,
                      due_date DATE,
                      id_user INT,
                      id_category INT,
                      FOREIGN KEY (id_user) REFERENCES user(id_user),
                      FOREIGN KEY (id_category) REFERENCES category(id_category)
)engine=InnoDB default charset=utf8;
package org.example.ui;

import org.example.persistence.dao.CategoryDAO;
import org.example.persistence.dao.TaskDAO;
import org.example.persistence.dao.UserDAO;
import org.example.persistence.entity.TaskEntity;

import java.util.Scanner;

public class Menu {
    public void execute(){
        System.out.println("Conectado ao banco de dados com sucesso!");
        Scanner scanner = new Scanner(System.in);

        TaskDAO taskDAO = new TaskDAO();
        UserDAO userDAO = new UserDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        int option;
        do {
            System.out.println("\n--- Menu de Opções ---");
            System.out.println("1. Inserir Tarefa");
            System.out.println("2. Buscar Tarefa por ID");
            System.out.println("3. Deletar Tarefa");
            System.out.println("4. Menu usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (option) {
                case 1:
                    System.out.print("Título da Tarefa: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição da Tarefa: ");
                    String description = scanner.nextLine();
                    System.out.print("Status da Tarefa: ");
                    String status = scanner.nextLine();
                    System.out.print("Data de Vencimento (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();

                    // fazer tratamento se existe os ids de usuario e categoria, mas a principio existem
                    System.out.print("ID do Usuário: ");
                    int userId = scanner.nextInt();
                    System.out.print("Categoria : ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();

                    TaskEntity newTask = new TaskEntity(title, description, status, dueDate, userId, categoryId);
                    taskDAO.insert(newTask);
                    System.out.println("Tarefa inserida com sucesso!");
                    break;

                case 2:
                    // Buscar tarefa por ID
                    System.out.print("Digite o ID da tarefa para buscar: ");
                    int taskIdToSearch = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada
                    break;

                case 3:
                    // Deletar tarefa
                    System.out.print("Digite o ID da tarefa para excluir: ");
                    int taskIdToDelete = scanner.nextInt();
                    scanner.nextLine();
                    taskDAO.delete(taskIdToDelete);
                    System.out.println("Tarefa deletada com sucesso!");
                    break;

                case 4:
                    MenuUser menuUser = new MenuUser();
                    menuUser.execute();
                    break;

                case 5:
                    System.out.println("Saindo do menu...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 5);
    }
}

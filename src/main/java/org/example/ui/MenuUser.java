package org.example.ui;

import org.example.persistence.dao.UserDAO;
import org.example.persistence.entity.UserEntity;

import java.util.Scanner;

public class MenuUser {

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n--- Menu de Usuário ---");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Deletar Usuário");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    Menu menuPrincipal = new Menu();

                    menuPrincipal.execute();
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 3);
    }

    private void addUser() {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setEmail(email);
        userDAO.insert(newUser);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void deleteUser() {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do usuário para deletar: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        userDAO.delete(userId);
        System.out.println("Usuário deletado com sucesso!");
    }
}


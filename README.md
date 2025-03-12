# 📋 Sistema de Gerenciamento de Tarefas com JDBC

Este é um sistema simples de gerenciamento de tarefas utilizando **Java** com **JDBC** para comunicação com um banco de dados MySQL. O sistema permite que usuários gerenciem tarefas, categorias e suas informações através de um menu interativo.

## 🚀 Tecnologias Utilizadas

- **JDBC (Java Database Connectivity)** - Para conexão com o banco de dados.
- **MySQL** - Banco de dados utilizado.
- **Maven** - Gerenciador de dependências.
- **Driver JDBC MySQL** - Biblioteca para conectar Java ao MySQL.

## 📜 Funcionalidades Implementadas
Gerenciamento de Usuários

- Criar usuários
- Deletar usuários
- Procurar por nome

- Criar categorias
- Deletar categorias


- Criar tarefas
- Buscar tarefas por ID
- Deletar tarefas

## 🖥️ Uso do Sistema
O sistema possui um menu interativo no terminal. Exemplo de funcionamento:
```
--- Menu de Opções ---
1. Inserir Tarefa
2. Buscar Tarefa por ID
3. Deletar Tarefa
4. Gerenciar Usuários
5. Sair
Escolha uma opção: 1
Título da Tarefa: Estudar JDBC
Descrição da Tarefa: Aprender sobre JDBC e MySQL.
Status da Tarefa: PENDING
Data de Vencimento (YYYY-MM-DD): 2025-03-15
ID do Usuário: 1
ID da Categoria: 1
Tarefa inserida com sucesso!

```

## 📌 Melhorias Futuras
- Implementação de um CRUD completo para usuários e categorias.
- Melhor organização do código seguindo padrões como DAO Pattern e MVC.
- Interface gráfica com JavaFX ou Spring Boot + Thymeleaf.
- Suporte para múltiplos bancos de dados (PostgreSQL, SQLite).

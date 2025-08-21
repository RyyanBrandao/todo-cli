# Lista de Tarefas em Java (TODO CLI)

## 🎯 Objetivo
Criar um programa simples em **Java** que rode no **terminal** e permita adicionar, listar e concluir tarefas.  
As tarefas são salvas em um arquivo `tasks.txt`.

## 🧰 Tecnologias utilizadas
- Java 17+
- VS Code (ou qualquer editor)
- Sem bibliotecas externas

## 📦 Estrutura do projeto


todo-cli/
├─ Main.java
├─ TaskList.java
└─ tasks.txt

## ▶️ Como executar
No terminal:
´´´´bash

javac Main.java TaskList.java
java Main

📋 Funcionalidades

1 → Adicionar tarefa

2 → Listar tarefas

3 → Concluir tarefa

0 → Sair

📚 O que eu aprendi

Uso de Scanner para entrada de dados.

Estruturas de repetição e decisão (while, switch).

Manipulação de listas com ArrayList.

Gravação e leitura de arquivos com Files.readAllLines e Files.write.

Organização do código em múltiplas classes (Main e TaskList).

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();
        list.load();

        System.out.println("=== Lista de Tarefas (TODO CLI) ===");
        while (true) {
            System.out.println("\n1) Adicionar tarefa");
            System.out.println("2) Listar tarefas");
            System.out.println("3) Concluir tarefa");
            System.out.println("0) Sair");
            System.out.print("> ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();
                    list.add(d);
                    System.out.println("✔ Tarefa adicionada!");
                    break;
                case "2":
                    List<TaskList.Task> tasks = list.all();
                    if (tasks.isEmpty()) {
                        System.out.println("(sem tarefas)");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            var t = tasks.get(i);
                            System.out.printf("%d. [%s] %s%n", i, t.done ? "x" : " ", t.desc);
                        }
                    }
                    break;
                case "3":
                    System.out.print("Índice da tarefa: ");
                    String idx = sc.nextLine().trim();
                    try {
                        int i = Integer.parseInt(idx);
                        System.out.println(list.complete(i) ? "✔ Concluída!" : "Índice inválido.");
                    } catch (NumberFormatException e) {
                        System.out.println("Digite um número válido.");
                    }
                    break;
                case "0":
                    System.out.println("Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

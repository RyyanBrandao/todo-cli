import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class TaskList {
    static class Task {
        String desc;
        boolean done;
        Task(String desc, boolean done) { this.desc = desc; this.done = done; }
    }

    private final Path file = Paths.get("tasks.txt");
    private final List<Task> tasks = new ArrayList<>();

    public void load() {
        tasks.clear();
        if (!Files.exists(file)) return;
        try {
            for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";", 2);
                boolean done = parts[0].equals("1");
                String desc = parts.length > 1 ? parts[1] : "";
                tasks.add(new Task(desc, done));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler tasks.txt (" + e.getMessage() + ")");
        }
    }

    public void save() {
        List<String> lines = new ArrayList<>();
        for (Task t : tasks) {
            lines.add((t.done ? "1" : "0") + ";" + t.desc);
        }
        try {
            Files.write(file, lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tasks.txt (" + e.getMessage() + ")");
        }
    }

    public void add(String desc) {
        if (desc == null || desc.isBlank()) return;
        tasks.add(new Task(desc.trim(), false));
        save();
    }

    public List<Task> all() { return Collections.unmodifiableList(tasks); }

    public boolean complete(int index) {
        if (index < 0 || index >= tasks.size()) return false;
        tasks.get(index).done = true;
        save();
        return true;
    }
}

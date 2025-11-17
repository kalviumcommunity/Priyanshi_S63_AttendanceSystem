package components.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileStorageService {

    public void saveData(List<? extends Storable> items, String filename) {
        Path path = Paths.get(filename);
        try {
            StringBuilder content = new StringBuilder();
            for (Storable item : items) {
                content.append(item.toDataString()).append(System.lineSeparator());
            }
            Files.write(path, content.toString().getBytes());
            System.out.println("Data successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    public void appendData(List<? extends Storable> items, String filename) {
        Path path = Paths.get(filename);
        try {
            StringBuilder content = new StringBuilder();
            for (Storable item : items) {
                content.append(item.toDataString()).append(System.lineSeparator());
            }
            Files.write(path, content.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Data successfully appended to " + filename);
        } catch (IOException e) {
            System.err.println("Error appending data to " + filename + ": " + e.getMessage());
        }
    }

    public List<String> readLines(String filename) {
        Path path = Paths.get(filename);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Error reading data from " + filename + ": " + e.getMessage());
            return List.of();
        }
    }
}

package components.school;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic file storage helper for simple CSV-like lines.
 * - saveData: writes each Storable.toDataString() as a line (overwrites file).
 * - appendData: appends lines to file.
 * - readLines: returns raw lines (caller converts via fromDataString).
 */
public class FileStorageService {

    public static void saveData(Path filePath, List<? extends Storable> items) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Storable s : items) {
            lines.add(s.toDataString());
        }
        Files.createDirectories(filePath.getParent() != null ? filePath.getParent() : Paths.get("."));
        Files.write(filePath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void appendData(Path filePath, List<? extends Storable> items) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Storable s : items) lines.add(s.toDataString());
        Files.createDirectories(filePath.getParent() != null ? filePath.getParent() : Paths.get("."));
        Files.write(filePath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static List<String> readLines(Path filePath) throws IOException {
        if (!Files.exists(filePath)) return new ArrayList<>();
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }
}
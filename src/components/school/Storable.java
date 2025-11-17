package components.school;

public interface Storable {
    /**
     * Convert the object to a single-line CSV-friendly string used by FileStorageService.
     * Implementations should not contain newline characters.
     */
    String toDataString();
}
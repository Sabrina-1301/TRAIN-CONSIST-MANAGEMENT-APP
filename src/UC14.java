import java.util.*;

// Custom Exception
class InvalidBogieCapacityException extends Exception {
    public InvalidBogieCapacityException(String message) {
        super(message);
    }
}

// Bogie Class
class Bogie {
    String bogieId;
    String type; // Passenger, Cargo
    int capacity;

    Bogie(String bogieId, String type, int capacity) throws InvalidBogieCapacityException {
        if (capacity <= 0) {
            throw new InvalidBogieCapacityException(
                    "Invalid capacity " + capacity + " for bogie " + bogieId + ". Capacity must be > 0."
            );
        }
        this.bogieId = bogieId;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return bogieId + " - " + type + " - Capacity: " + capacity;
    }
}

// Train Class
class Train {
    List<Bogie> bogies = new ArrayList<>();

    void addBogie(Bogie b) {
        bogies.add(b);
        System.out.println("Bogie " + b.bogieId + " added successfully.");
    }

    void displayBogies() {
        System.out.println("Train Bogies:");
        bogies.forEach(System.out::println);
    }
}

// Main Class
public class UC14 {

    public static void main(String[] args) {

        Train train = new Train();

        try {
            train.addBogie(new Bogie("BG101", "Sleeper", 72));
            train.addBogie(new Bogie("BG102", "AC", 56));
            train.addBogie(new Bogie("BG103", "General", 0)); // Invalid
        } catch (InvalidBogieCapacityException e) {
            System.out.println("Error adding bogie: " + e.getMessage());
        }

        try {
            train.addBogie(new Bogie("BG104", "Cargo", -50)); // Invalid
        } catch (InvalidBogieCapacityException e) {
            System.out.println("Error adding bogie: " + e.getMessage());
        }

        // Display successfully added bogies
        System.out.println("\nCurrent Train Bogies:");
        train.displayBogies();
    }
}
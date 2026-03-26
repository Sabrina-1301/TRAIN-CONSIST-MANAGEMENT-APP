import java.util.*;

// Bogie Class
class Bogie {
    String bogieId;
    String type; // Passenger, Cargo, etc.
    int capacity;

    Bogie(String bogieId, String type, int capacity) {
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
    String trainName;
    ArrayList<Bogie> bogies; // List allows sorting

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    // Add bogie (ensure uniqueness by ID)
    void addBogie(Bogie b) {
        for (Bogie existing : bogies) {
            if (existing.bogieId.equals(b.bogieId)) {
                System.out.println("Error: Bogie " + b.bogieId + " already exists.");
                return;
            }
        }
        bogies.add(b);
        System.out.println("Bogie " + b.bogieId + " added.");
    }

    // Sort bogies by capacity (descending)
    void sortBogiesByCapacity() {
        bogies.sort(new Comparator<Bogie>() {
            @Override
            public int compare(Bogie b1, Bogie b2) {
                return b2.capacity - b1.capacity; // descending
            }
        });
        System.out.println("Bogies sorted by capacity (high → low).");
    }

    // Display bogies
    void displayBogies() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Bogies: " + bogies.size());
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}

// Main Class
public class UC7 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC Chair", 56));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG104", "AC Sleeper", 48));

        // Display original order
        System.out.println("Original bogie order:");
        train.displayBogies();

        // Sort by capacity
        train.sortBogiesByCapacity();

        // Display sorted order
        System.out.println("\nAfter sorting by capacity:");
        train.displayBogies();
    }
}
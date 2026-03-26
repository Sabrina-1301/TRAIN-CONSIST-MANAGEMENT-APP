import java.util.*;

// Bogie Class
class Bogie {
    String bogieId;
    String type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bogie)) return false;
        Bogie bogie = (Bogie) o;
        return bogieId.equals(bogie.bogieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bogieId);
    }
}

// Train Class
class Train {
    String trainName;
    LinkedHashSet<Bogie> bogies; // Preserves insertion order + uniqueness

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new LinkedHashSet<>();
    }

    // Add bogie
    void addBogie(Bogie b) {
        if (bogies.add(b)) {
            System.out.println("Bogie " + b.bogieId + " added.");
        } else {
            System.out.println("Error: Bogie " + b.bogieId + " already exists. Cannot add duplicate.");
        }
    }

    // Remove last-added bogie (LIFO)
    void removeLastBogie() {
        if (bogies.isEmpty()) {
            System.out.println("No bogies to remove.");
            return;
        }

        Bogie lastBogie = null;
        for (Bogie b : bogies) {
            lastBogie = b; // LinkedHashSet iterates in insertion order
        }

        bogies.remove(lastBogie);
        System.out.println("Last added bogie " + lastBogie.bogieId + " removed (LIFO).");
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
public class UC5 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 50));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG101", "Duplicate Sleeper", 72)); // Duplicate

        // Display all bogies
        train.displayBogies();

        // Remove last-added bogie (LIFO)
        train.removeLastBogie();

        // Display after removal
        train.displayBogies();
    }
}
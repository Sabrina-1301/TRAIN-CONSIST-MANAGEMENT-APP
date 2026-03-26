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
    HashMap<String, Bogie> bogieMap; // Maps bogieId to Bogie object

    Train(String trainName) {
        this.trainName = trainName;
        this.bogieMap = new HashMap<>();
    }

    // Add bogie
    void addBogie(Bogie b) {
        if (bogieMap.containsKey(b.bogieId)) {
            System.out.println("Error: Bogie " + b.bogieId + " already exists.");
        } else {
            bogieMap.put(b.bogieId, b);
            System.out.println("Bogie " + b.bogieId + " added with capacity " + b.capacity);
        }
    }

    // Remove bogie
    void removeBogie(String bogieId) {
        if (bogieMap.containsKey(bogieId)) {
            bogieMap.remove(bogieId);
            System.out.println("Bogie " + bogieId + " removed.");
        } else {
            System.out.println("Bogie " + bogieId + " not found.");
        }
    }

    // Get bogie capacity
    void displayBogieCapacity(String bogieId) {
        Bogie b = bogieMap.get(bogieId);
        if (b != null) {
            System.out.println("Bogie " + bogieId + " has capacity: " + b.capacity);
        } else {
            System.out.println("Bogie " + bogieId + " not found.");
        }
    }

    // Display all bogies
    void displayAllBogies() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Bogies: " + bogieMap.size());
        for (Bogie b : bogieMap.values()) {
            System.out.println(b);
        }
    }
}

// Main Class
public class UC6 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 50));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG101", "Duplicate", 60)); // Duplicate attempt

        // Display all bogies
        train.displayAllBogies();

        // Display individual bogie capacity
        train.displayBogieCapacity("BG102");

        // Remove a bogie
        train.removeBogie("BG102");

        // Display after removal
        train.displayAllBogies();
    }
}
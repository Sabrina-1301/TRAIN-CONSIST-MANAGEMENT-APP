import java.util.*;
import java.util.stream.*;

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
    ArrayList<Bogie> bogies;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    // Add bogie
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

    // Filter passenger bogies by minimum capacity using Stream
    List<Bogie> filterPassengerBogies(int minCapacity) {
        return bogies.stream()
                .filter(b -> b.type.equalsIgnoreCase("Passenger") || b.type.equalsIgnoreCase("Sleeper") || b.type.equalsIgnoreCase("AC"))
                .filter(b -> b.capacity >= minCapacity)
                .collect(Collectors.toList());
    }

    // Display bogies
    void displayBogies(List<Bogie> bogieList) {
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
    }
}

// Main Class
public class UC8 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 56));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG104", "Cargo", 120));

        System.out.println("\nAll Bogies:");
        train.displayBogies(train.bogies);

        // Filter passenger bogies with capacity >= 60
        System.out.println("\nFiltered Passenger Bogies (capacity >= 60):");
        List<Bogie> filtered = train.filterPassengerBogies(60);
        train.displayBogies(filtered);
    }
}
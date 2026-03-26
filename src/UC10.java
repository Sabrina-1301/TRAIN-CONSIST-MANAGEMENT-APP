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

    // Compute total passenger seats using reduce
    int totalPassengerSeats() {
        return bogies.stream()
                .filter(b -> b.type.equalsIgnoreCase("Passenger") || b.type.equalsIgnoreCase("Sleeper") || b.type.equalsIgnoreCase("AC"))
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // Display all bogies
    void displayBogies() {
        System.out.println("Train: " + trainName);
        bogies.forEach(System.out::println);
    }
}

// Main Class
public class UC10 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 56));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG104", "Cargo", 120));
        train.addBogie(new Bogie("BG105", "AC", 50));
        train.addBogie(new Bogie("BG106", "Sleeper", 80));

        // Display all bogies
        System.out.println("\nAll Bogies:");
        train.displayBogies();

        // Calculate total passenger seats
        int totalSeats = train.totalPassengerSeats();
        System.out.println("\nTotal Passenger Seats in Train: " + totalSeats);
    }
}

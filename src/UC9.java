import java.util.*;
import java.util.stream.*;

// Bogie Class
class Bogie {
    String bogieId;
    String type; // Passenger, Cargo, Sleeper, AC, etc.
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

    // Group bogies by type
    Map<String, List<Bogie>> groupBogiesByType() {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    // Display grouped bogies
    void displayGroupedBogies(Map<String, List<Bogie>> grouped) {
        for (String type : grouped.keySet()) {
            System.out.println("\nBogie Type: " + type);
            grouped.get(type).forEach(b -> System.out.println(b));
        }
    }
}

// Main Class
public class UC9 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 56));
        train.addBogie(new Bogie("BG103", "General", 90));
        train.addBogie(new Bogie("BG104", "Cargo", 120));
        train.addBogie(new Bogie("BG105", "AC", 50));
        train.addBogie(new Bogie("BG106", "Sleeper", 80));

        // Group bogies by type
        Map<String, List<Bogie>> grouped = train.groupBogiesByType();

        // Display grouped bogies
        train.displayGroupedBogies(grouped);
    }
}
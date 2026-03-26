import java.util.*;

// Bogie Class
class Bogie implements Comparable<Bogie> {
    String bogieId;
    String type;
    int capacity;

    Bogie(String bogieId, String type, int capacity) {
        this.bogieId = bogieId;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Bogie other) {
        return this.bogieId.compareTo(other.bogieId);
    }

    @Override
    public String toString() {
        return bogieId + " - " + type + " - Capacity: " + capacity;
    }
}

// Train Class
class Train {
    String trainName;

    // Ordered bogies (TreeSet ensures uniqueness + order)
    TreeSet<Bogie> orderedBogies;

    Train(String trainName) {
        this.trainName = trainName;
        this.orderedBogies = new TreeSet<>();
    }

    // Add bogie
    void addBogie(Bogie b) {
        boolean added = orderedBogies.add(b);
        if (added) {
            System.out.println("Bogie " + b.bogieId + " added in order.");
        } else {
            System.out.println("Bogie " + b.bogieId + " already exists. Cannot add duplicate.");
        }
    }

    // Remove bogie
    void removeBogie(String bogieId) {
        Bogie dummy = new Bogie(bogieId, "", 0);
        boolean removed = orderedBogies.remove(dummy);

        if (removed) {
            System.out.println("Bogie " + bogieId + " removed successfully.");
        } else {
            System.out.println("Bogie " + bogieId + " not found.");
        }
    }

    // Display bogies in order
    void displayBogies() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Bogies: " + orderedBogies.size());
        for (Bogie b : orderedBogies) {
            System.out.println(b);
        }
    }
}

// Main Class
public class UC4 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("B03", "General", 90));
        train.addBogie(new Bogie("B01", "Sleeper", 72));
        train.addBogie(new Bogie("B02", "AC", 50));
        train.addBogie(new Bogie("B01", "Sleeper Duplicate", 72)); // Duplicate

        // Display in order
        train.displayBogies();

        // Remove a bogie
        train.removeBogie("B02");

        // Display after removal
        train.displayBogies();
    }
}
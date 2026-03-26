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
}

// Train Class
class Train {
    String trainName;
    ArrayList<Bogie> bogies;
    HashSet<String> uniqueBogieIds;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
        this.uniqueBogieIds = new HashSet<>();
    }

    // Add bogie with uniqueness check
    void addBogie(Bogie b) {
        if (uniqueBogieIds.contains(b.bogieId)) {
            System.out.println("Error: Bogie ID " + b.bogieId + " already exists. Cannot add duplicate.");
            return;
        }

        bogies.add(b);
        uniqueBogieIds.add(b.bogieId);
        System.out.println("Bogie " + b.bogieId + " added successfully.");
    }

    // Remove bogie
    void removeBogie(String bogieId) {
        Iterator<Bogie> it = bogies.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Bogie b = it.next();
            if (b.bogieId.equals(bogieId)) {
                it.remove();
                uniqueBogieIds.remove(bogieId);
                System.out.println("Bogie " + bogieId + " removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bogie " + bogieId + " not found.");
        }
    }

    // Display all bogies
    void displayBogies() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Bogies: " + bogies.size());
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}

// Main Class
public class UC3 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC", 50));
        train.addBogie(new Bogie("BG101", "General", 90)); // Duplicate

        // Display all bogies
        train.displayBogies();

        // Remove a bogie
        train.removeBogie("BG102");

        // Display after removal
        train.displayBogies();
    }
}
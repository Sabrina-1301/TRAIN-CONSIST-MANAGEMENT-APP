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
        bogies.add(b);
        System.out.println("Bogie " + b.bogieId + " added.");
    }

    // Remove bogie by ID
    void removeBogie(String bogieId) {
        Iterator<Bogie> it = bogies.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Bogie b = it.next();
            if (b.bogieId.equals(bogieId)) {
                it.remove();
                System.out.println("Bogie " + bogieId + " removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bogie " + bogieId + " not found.");
        }
    }

    // Check if bogie exists
    void searchBogie(String bogieId) {
        for (Bogie b : bogies) {
            if (b.bogieId.equals(bogieId)) {
                System.out.println("Bogie " + bogieId + " exists.");
                return;
            }
        }
        System.out.println("Bogie " + bogieId + " does not exist.");
    }

    // Display all bogies
    void displayBogies() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Bogies: " + bogies.size());

        for (Bogie b : bogies) {
            System.out.println(b.bogieId + " - " + b.type + " - Capacity: " + b.capacity);
        }
    }
}

// Main Class
public class UC2 {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new Bogie("B1", "Sleeper", 72));
        train.addBogie(new Bogie("B2", "AC", 50));
        train.addBogie(new Bogie("B3", "General", 90));

        // Display
        train.displayBogies();

        // Search bogie
        train.searchBogie("B2");

        // Remove bogie
        train.removeBogie("B2");

        // Display after removal
        train.displayBogies();
    }
}
import java.util.Scanner;

// If this is in the same package as other UCs,
// ensure 'Bogie' isn't already defined elsewhere.
class TrainBogie {
    String id;
    String type;

    public TrainBogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bogie [ID=" + id + ", Type=" + type + "]";
    }
}

public class UC18 {
    public static void main(String[] args) {
        // Array-based consist (Collection of bogies)
        TrainBogie[] consist = {
                new TrainBogie("B-101", "Sleeper"),
                new TrainBogie("B-205", "AC Chair"),
                new TrainBogie("G-500", "Cylindrical"),
                new TrainBogie("B-310", "First Class"),
                new TrainBogie("G-102", "Rectangular")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Railway Consist Search Tool ---");
        System.out.print("Enter Bogie ID to locate: ");
        String targetID = scanner.nextLine();

        // --- Linear Search Logic ---
        int foundIndex = -1;
        for (int i = 0; i < consist.length; i++) {
            // Case-insensitive comparison to avoid operator input errors
            if (consist[i].id.equalsIgnoreCase(targetID)) {
                foundIndex = i;
                break; // Exit loop early once found
            }
        }

        // Display results
        if (foundIndex != -1) {
            System.out.println("\n[MATCH FOUND]");
            System.out.println("Location: Position " + (foundIndex + 1) + " behind the engine.");
            System.out.println("Details: " + consist[foundIndex]);
        } else {
            System.out.println("\n[SEARCH FAILED]");
            System.out.println("Bogie ID '" + targetID + "' is not attached to this consist.");
        }

        scanner.close();
    }
}
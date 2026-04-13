import java.util.Arrays;
import java.util.Scanner;

class ConsistBogie {
    String id;
    String type;

    public ConsistBogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + id + " | " + type + "]";
    }
}

public class UC19 {
    public static void main(String[] args) {
        // 1. Setup the Consist
        ConsistBogie[] bogies = {
                new ConsistBogie("B-900", "Sleeper"),
                new ConsistBogie("B-102", "AC Chair"),
                new ConsistBogie("G-550", "Cylindrical"),
                new ConsistBogie("A-001", "Engine"),
                new ConsistBogie("G-110", "Rectangular")
        };

        // 2. PREREQUISITE: Sort by ID before Binary Search
        // We use a Lambda to tell Java to sort based on the 'id' field
        Arrays.sort(bogies, (a, b) -> a.id.compareTo(b.id));

        System.out.println("Sorted Consist (Required for Binary Search):");
        for (ConsistBogie b : bogies) System.out.println(b);

        // 3. Search Operation
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Bogie ID to find: ");
        String targetID = scanner.nextLine();

        // --- Binary Search Algorithm ---
        int low = 0;
        int high = bogies.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = targetID.compareTo(bogies[mid].id);

            if (comparison == 0) {
                foundIndex = mid;
                break; // Match found!
            } else if (comparison > 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        // 4. Output Result
        if (foundIndex != -1) {
            System.out.println("MATCH FOUND: " + bogies[foundIndex] + " at index " + foundIndex);
        } else {
            System.out.println("RESULT: Bogie " + targetID + " not found in the system.");
        }

        scanner.close();
    }
}
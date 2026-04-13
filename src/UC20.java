import java.util.Arrays;
import java.util.Scanner;

// Custom Exception to handle railway logic errors
class EmptyConsistException extends Exception {
    public EmptyConsistException(String message) {
        super(message);
    }
}

// Renamed class to avoid "Duplicate Class" or "Bogie Error"
class RailwayBogie {
    String id;
    String type;

    public RailwayBogie(String id, String type) {
        this.id = id;
        this.type = type;
    }
}

public class UC20 {
    public static void main(String[] args) {
        // Scenario: Empty array (No bogies attached yet)
        RailwayBogie[] consist = {};

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Railway Search Audit System ---");
        System.out.print("Enter Bogie ID to locate: ");
        String targetID = scanner.nextLine();

        try {
            // Validate first: Fail-Fast if the train is empty
            validateConsist(consist);

            // If valid, proceed with search logic
            searchBogie(consist, targetID);

        } catch (EmptyConsistException e) {
            // Handling the business logic error gracefully
            System.err.println("ALERT: " + e.getMessage());
            System.out.println("Operator Note: Attach bogies before initiating search.");

        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Log: Search operation process closed.");
        }
    }

    // Method to check system state before heavy computation
    public static void validateConsist(RailwayBogie[] consist) throws EmptyConsistException {
        if (consist == null || consist.length == 0) {
            throw new EmptyConsistException("Search failed: The train consist has no bogies.");
        }
    }

    public static void searchBogie(RailwayBogie[] consist, String targetID) {
        // Sort IDs for Binary Search
        Arrays.sort(consist, (a, b) -> a.id.compareTo(b.id));

        int low = 0, high = consist.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = targetID.compareTo(consist[mid].id);

            if (res == 0) {
                System.out.println("Success: Bogie " + targetID + " located at slot " + mid);
                found = true;
                break;
            } else if (res > 0) low = mid + 1;
            else high = mid - 1;
        }

        if (!found) System.out.println("Notice: Bogie " + targetID + " is not in this consist.");
    }
}


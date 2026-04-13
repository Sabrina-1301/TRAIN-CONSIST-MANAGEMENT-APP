// Custom Runtime Exception for railway safety violations
class UnsafeCargoException extends RuntimeException {
    public UnsafeCargoException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String bogieID;
    private String type; // "Rectangular" or "Cylindrical"

    public GoodsBogie(String bogieID, String type) {
        this.bogieID = bogieID;
        this.type = type;
    }

    // Dynamic assignment method that might throw a safety exception
    public void assignCargo(String cargoName) throws UnsafeCargoException {
        System.out.println("LOG: Initiating loading for Bogie " + bogieID + " (" + type + ")");

        // Safety Policy: Liquid fuel (Petroleum) requires Cylindrical bogies
        if (cargoName.equalsIgnoreCase("Petroleum") && !type.equalsIgnoreCase("Cylindrical")) {
            throw new UnsafeCargoException("CRITICAL SAFETY ERROR: Cannot load " + cargoName + " into a " + type + " bogie.");
        }

        System.out.println("SUCCESS: " + cargoName + " safely secured in " + bogieID);
    }
}

public class UC15 {
    public static void main(String[] args) {
        // Scenario: Operator attempts to load petroleum into a standard rectangular bogie
        GoodsBogie myBogie = new GoodsBogie("GB-789", "Rectangular");

        try {
            System.out.println("--- Starting Cargo Assignment Operation ---");
            myBogie.assignCargo("Petroleum");

        } catch (UnsafeCargoException e) {
            // Handling the specific safety violation without crashing the app
            System.err.println("STOPPED: Assignment rejected by safety protocol.");
            System.err.println("REASON: " + e.getMessage());

        } catch (Exception e) {
            // General catch for any other unexpected runtime issues
            System.err.println("SYSTEM ERROR: An unexpected failure occurred: " + e.getMessage());

        } finally {
            // Mandatory cleanup: ensuring the track is clear and logs are updated
            System.out.println("CLEANUP: Releasing track locks and updating station database.");
            System.out.println("--- Operation Finalized ---");
        }

        // The application continues to run even after an exception
        System.out.println("\nSTATUS: System remains operational for next command.");
    }
}
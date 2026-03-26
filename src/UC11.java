import java.util.regex.*;

public class UC11 {

    // Validate Train ID (format: TRN-1234)
    public static boolean validateTrainID(String trainID) {
        String pattern = "^TRN-\\d{4}$"; // TRN- followed by 4 digits
        return Pattern.matches(pattern, trainID);
    }

    // Validate Cargo Code (format: CG-XXXX where X is uppercase letter or digit)
    public static boolean validateCargoCode(String cargoCode) {
        String pattern = "^CG-[A-Z0-9]{4}$"; // CG- followed by 4 alphanumeric uppercase chars
        return Pattern.matches(pattern, cargoCode);
    }

    public static void main(String[] args) {

        // Test Train IDs
        String[] trainIDs = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-5678"};
        System.out.println("Train ID Validation:");
        for (String id : trainIDs) {
            System.out.printf("%s -> %s%n", id, validateTrainID(id) ? "Valid" : "Invalid");
        }

        // Test Cargo Codes
        String[] cargoCodes = {"CG-A1B2", "CG-1234", "CG-ab12", "CG-12", "CG-XYZ9"};
        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes) {
            System.out.printf("%s -> %s%n", code, validateCargoCode(code) ? "Valid" : "Invalid");
        }
    }
}
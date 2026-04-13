import java.util.Arrays;

public class UC17 {
    public static void main(String[] args) {
        // A list of bogie types in a disorganized arrival order
        String[] bogieTypes = {
                "Sleeper",
                "AC Chair Car",
                "General",
                "First Class",
                "Cylindrical Goods",
                "Rectangular Goods",
                "Executive"
        };

        System.out.println("--- Railway Inventory: Pre-Sort ---");
        printBogieList(bogieTypes);

        // --- Optimized Built-in Sorting ---
        // Arrays.sort() uses highly optimized algorithms (O(n log n))
        Arrays.sort(bogieTypes);

        System.out.println("\n--- Railway Inventory: Alphabetical Sort (Arrays.sort) ---");
        printBogieList(bogieTypes);
    }

    private static void printBogieList(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }
}
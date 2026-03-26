import java.util.*;
import java.util.stream.*;

// Bogie Class
class Bogie {
    String bogieId;
    String type; // Passenger, Cargo, etc.
    int capacity;

    Bogie(String bogieId, String type, int capacity) {
        this.bogieId = bogieId;
        this.type = type;
        this.capacity = capacity;
    }
}

// Train Class
class Train {
    List<Bogie> bogies;

    Train(int totalBogies) {
        bogies = new ArrayList<>();
        Random rand = new Random();
        String[] types = {"Sleeper", "AC", "General", "Cargo"};
        // Initialize large number of bogies
        for (int i = 1; i <= totalBogies; i++) {
            String type = types[rand.nextInt(types.length)];
            int capacity = rand.nextInt(100) + 20; // capacity 20-119
            bogies.add(new Bogie("BG" + i, type, capacity));
        }
    }

    // Total passenger seats using traditional loop
    int totalSeatsLoop() {
        int sum = 0;
        for (Bogie b : bogies) {
            if (b.type.equalsIgnoreCase("Sleeper") || b.type.equalsIgnoreCase("AC") || b.type.equalsIgnoreCase("General")) {
                sum += b.capacity;
            }
        }
        return sum;
    }

    // Total passenger seats using Stream
    int totalSeatsStream() {
        return bogies.stream()
                .filter(b -> b.type.equalsIgnoreCase("Sleeper") || b.type.equalsIgnoreCase("AC") || b.type.equalsIgnoreCase("General"))
                .mapToInt(b -> b.capacity)
                .sum();
    }
}

// Main Class
public class UC13 {

    public static void main(String[] args) {

        int totalBogies = 1_000_000; // large dataset for performance test
        Train train = new Train(totalBogies);

        // Benchmark traditional loop
        long startLoop = System.nanoTime();
        int totalLoop = train.totalSeatsLoop();
        long endLoop = System.nanoTime();
        long durationLoop = endLoop - startLoop;

        // Benchmark Stream API
        long startStream = System.nanoTime();
        int totalStream = train.totalSeatsStream();
        long endStream = System.nanoTime();
        long durationStream = endStream - startStream;

        // Output results
        System.out.println("Performance Comparison (1,000,000 bogies):");
        System.out.printf("Total Seats (Loop): %d, Time: %d ns%n", totalLoop, durationLoop);
        System.out.printf("Total Seats (Stream): %d, Time: %d ns%n", totalStream, durationStream);

        if (durationLoop < durationStream) {
            System.out.println("Loop is faster for this operation.");
        } else {
            System.out.println("Stream is faster for this operation.");
        }
    }
}
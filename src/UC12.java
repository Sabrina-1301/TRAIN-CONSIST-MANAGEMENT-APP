import java.util.*;
import java.util.stream.*;

// Goods Bogie Class
class GoodsBogie {
    String bogieId;
    String shape;   // Cylindrical, Box, Flat, Tanker
    String cargo;   // Coal, Oil, Grains, Chemicals

    GoodsBogie(String bogieId, String shape, String cargo) {
        this.bogieId = bogieId;
        this.shape = shape;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return bogieId + " - " + shape + " - Cargo: " + cargo;
    }
}

// Train Class for Goods Bogies
class GoodsTrain {
    String trainName;
    List<GoodsBogie> goodsBogies;

    GoodsTrain(String trainName) {
        this.trainName = trainName;
        this.goodsBogies = new ArrayList<>();
    }

    // Add goods bogie
    void addBogie(GoodsBogie b) {
        goodsBogies.add(b);
        System.out.println("Bogie " + b.bogieId + " added.");
    }

    // Safety compliance check using Stream
    List<GoodsBogie> unsafeBogies() {
        return goodsBogies.stream()
                .filter(b -> !isSafe(b))
                .collect(Collectors.toList());
    }

    // Business rule: Cylindrical -> Oil only, Box -> Grains/Coal, Flat -> Coal only, Tanker -> Chemicals
    private boolean isSafe(GoodsBogie b) {
        switch (b.shape.toLowerCase()) {
            case "cylindrical":
                return b.cargo.equalsIgnoreCase("Oil");
            case "box":
                return b.cargo.equalsIgnoreCase("Grains") || b.cargo.equalsIgnoreCase("Coal");
            case "flat":
                return b.cargo.equalsIgnoreCase("Coal");
            case "tanker":
                return b.cargo.equalsIgnoreCase("Chemicals");
            default:
                return false;
        }
    }

    // Display all bogies
    void displayBogies() {
        System.out.println("Train: " + trainName);
        goodsBogies.forEach(System.out::println);
    }
}

// Main Class
public class UC12 {

    public static void main(String[] args) {

        GoodsTrain train = new GoodsTrain("Freight Express");

        // Add goods bogies
        train.addBogie(new GoodsBogie("GB101", "Cylindrical", "Oil"));
        train.addBogie(new GoodsBogie("GB102", "Cylindrical", "Coal"));       // Unsafe
        train.addBogie(new GoodsBogie("GB103", "Box", "Grains"));
        train.addBogie(new GoodsBogie("GB104", "Flat", "Coal"));
        train.addBogie(new GoodsBogie("GB105", "Tanker", "Chemicals"));
        train.addBogie(new GoodsBogie("GB106", "Box", "Oil"));                 // Unsafe

        // Display all bogies
        System.out.println("\nAll Goods Bogies:");
        train.displayBogies();

        // Perform safety compliance check
        List<GoodsBogie> unsafe = train.unsafeBogies();

        // Display unsafe bogies
        System.out.println("\nUnsafe Bogies Detected:");
        if (unsafe.isEmpty()) {
            System.out.println("All goods bogies are compliant with safety rules.");
        } else {
            unsafe.forEach(System.out::println);
        }
    }
}
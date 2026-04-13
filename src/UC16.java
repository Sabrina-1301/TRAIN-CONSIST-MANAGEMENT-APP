class PassengerBogie {
    String classType;
    int capacity;

    public PassengerBogie(String classType, int capacity) {
        this.classType = classType;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "[" + classType + " | Cap: " + capacity + "]";
    }
}

public class UC16 {
    public static void main(String[] args) {
        // Initializing an array of Passenger Bogies (Manual setup)
        PassengerBogie[] trainConsist = {
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair Car", 56),
                new PassengerBogie("First Class", 24),
                new PassengerBogie("General", 90),
                new PassengerBogie("Executive", 30)
        };

        System.out.println("Before Sorting (Arrival Order):");
        printConsist(trainConsist);

        // --- Bubble Sort Algorithm Implementation ---
        int n = trainConsist.length;
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place, so we ignore them
            for (int j = 0; j < n - i - 1; j++) {

                // Compare capacity of adjacent bogies
                if (trainConsist[j].capacity > trainConsist[j + 1].capacity) {

                    // SWAP: If the current bogie is larger than the next, swap them
                    PassengerBogie temp = trainConsist[j];
                    trainConsist[j] = trainConsist[j + 1];
                    trainConsist[j + 1] = temp;

                    System.out.println("  Swapping " + trainConsist[j + 1].classType + " with " + trainConsist[j].classType);
                }
            }
        }

        System.out.println("\nAfter Sorting (By Capacity - Ascending):");
        printConsist(trainConsist);
    }

    private static void printConsist(PassengerBogie[] bogies) {
        for (PassengerBogie b : bogies) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}

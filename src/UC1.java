import java.util.*;

// Coach Class
class Coach {
    String coachId;
    String type;
    int capacity;

    Coach(String coachId, String type, int capacity) {
        this.coachId = coachId;
        this.type = type;
        this.capacity = capacity;
    }
}

// Train Class
class Train {
    String trainName;
    List<Coach> coaches;

    Train(String trainName) {
        this.trainName = trainName;
        this.coaches = new ArrayList<>();
    }

    // Add coach to train
    void addCoach(Coach coach) {
        coaches.add(coach);
    }

    // Display consist summary
    void displaySummary() {
        System.out.println("Train Name: " + trainName);
        System.out.println("Total Coaches: " + coaches.size());

        int totalCapacity = 0;

        for (Coach c : coaches) {
            System.out.println("Coach ID: " + c.coachId +
                    ", Type: " + c.type +
                    ", Capacity: " + c.capacity);
            totalCapacity += c.capacity;
        }

        System.out.println("Total Capacity: " + totalCapacity);
    }
}

// Main Class
public class UC1 {

    public static void main(String[] args) {

        // Initialize Train
        Train train = new Train("Express Line");

        // Add coaches
        train.addCoach(new Coach("C1", "Sleeper", 72));
        train.addCoach(new Coach("C2", "AC", 50));
        train.addCoach(new Coach("C3", "General", 90));

        // Display initial state
        train.displaySummary();
    }
}

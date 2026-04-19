import java.util.*;

// Food Stall Class
class FoodStall {
    private String stallName;
    private Vector<String> dishes;  // Chefs update dishes using Vector

    public FoodStall(String stallName) {
        this.stallName = stallName;
        this.dishes = new Vector<>();
    }

    public String getStallName() {
        return stallName;
    }

    public void addDish(String dish) {
        dishes.add(dish);
    }

    public void showDishes() {
        System.out.println("Dishes at " + stallName + ": " + dishes);
    }
}

// Customer Class
class Customer {
    private String name;
    private Stack<String> visitedStalls; // Track last visited stalls

    public Customer(String name) {
        this.name = name;
        this.visitedStalls = new Stack<>();
    }

    public String getName() {
        return name;
    }

    public void visitStall(String stallName) {
        visitedStalls.push(stallName);
    }

    public void showLastVisited() {
        if (!visitedStalls.isEmpty()) {
            System.out.println(name + "'s last visited stall: " + visitedStalls.peek());
        } else {
            System.out.println(name + " has not visited any stall yet.");
        }
    }
}

// Main Festival Class
class MagicalFoodFestival {

    // Store all food stalls
    static ArrayList<FoodStall> stalls = new ArrayList<>();

    // Customers waiting in line
    static Queue<Customer> customerQueue = new LinkedList<>();

    // Daily customer history
    static LinkedList<String> dailyHistory = new LinkedList<>();

    public static void main(String[] args) {

        // 🔹 Add New Food Stalls
        FoodStall stall1 = new FoodStall("Italian Delight");
        stall1.addDish("Pizza");
        stall1.addDish("Pasta");

        FoodStall stall2 = new FoodStall("Asian Spice");
        stall2.addDish("Sushi");
        stall2.addDish("Noodles");

        stalls.add(stall1);
        stalls.add(stall2);

        System.out.println("Food Stalls Added Successfully!\n");

        // Show all stalls and dishes
        for (FoodStall stall : stalls) {
            stall.showDishes();
        }

        // 🔹 Add Customers to Queue
        customerQueue.add(new Customer("Alice"));
        customerQueue.add(new Customer("Bob"));
        customerQueue.add(new Customer("Charlie"));

        System.out.println("\nServing Customers...\n");

        // 🔹 Serve Customers in Order
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.poll();
            System.out.println("Serving: " + customer.getName());

            // Customer visits first stall
            customer.visitStall(stalls.get(0).getStallName());
            customer.showLastVisited();

            // Add to daily history
            dailyHistory.add(customer.getName());
        }

        // 🔹 Show Daily Festival History
        System.out.println("\nDaily Customer History:");
        for (String name : dailyHistory) {
            System.out.println(name);
        }
    }
}

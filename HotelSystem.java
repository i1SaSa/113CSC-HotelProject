public class HotelSystem {
    private Reservation[] reservations;
    private int numOfRes;
    private Customer[] customers;
    private int numOfCustomers;

    public HotelSystem(int maxReservations, int maxCustomers) {
        this.reservations = new Reservation[maxReservations];
        this.numOfRes = 0;
        this.customers = new Customer[maxCustomers];
        this.numOfCustomers = 0;
    }

    public int getNumOfCustomers() { return numOfCustomers; }
    public int getNumOfRes() { return numOfRes; }

    // ─── Customer methods ───────────────────────────────────────────────────

    public boolean addCustomer(Customer customer) {
        if (numOfCustomers < customers.length) {
            customers[numOfCustomers] = customer;
            numOfCustomers++;
            return true;
        }
        System.out.println("Error: Cannot add customer. Maximum capacity reached.");
        return false;
    }

    public boolean removeCustomer(String name) {
        for (int i = 0; i < numOfCustomers; i++) {
            if (customers[i].getName().equals(name)) {
                for (int j = i; j < numOfCustomers - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[numOfCustomers - 1] = null;
                numOfCustomers--;
                System.out.println("Customer " + name + " removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Customer " + name + " not found.");
        return false;
    }

    public Customer searchCustomer(String name) {
        for (int i = 0; i < numOfCustomers; i++) {
            if (customers[i].getName().equals(name)) {
                return customers[i];
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        if (numOfCustomers == 0) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("\n========== All Customers ==========");
        for (int i = 0; i < numOfCustomers; i++) {
            System.out.println(customers[i]);
        }
        System.out.println("===================================");
    }

    // ─── Reservation methods ────────────────────────────────────────────────

    public boolean addReservation(Reservation reservation) {
        // Check for duplicate ID
        if (searchReservation(reservation.getResID()) != -1) {
            System.out.println("Error: Reservation ID '" + reservation.getResID() + "' already exists.");
            return false;
        }
        if (numOfRes < reservations.length) {
            reservations[numOfRes] = reservation;
            numOfRes++;
            return true;
        }
        System.out.println("Error: Cannot add reservation. Maximum capacity reached.");
        return false;
    }

    public boolean removeReservation(String resID) {
        for (int i = 0; i < numOfRes; i++) {
            if (reservations[i].getResID().equals(resID)) {
                for (int j = i; j < numOfRes - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[numOfRes - 1] = null;
                numOfRes--;
                System.out.println("Reservation " + resID + " removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Reservation " + resID + " not found.");
        return false;
    }

    public int searchReservation(String resID) {
        for (int i = 0; i < numOfRes; i++) {
            if (reservations[i].getResID().equals(resID)) {
                return i;
            }
        }
        return -1;
    }

    public Reservation getReservation(String resID) {
        int idx = searchReservation(resID);
        return idx != -1 ? reservations[idx] : null;
    }

    public void displayAllReservations() {
        if (numOfRes == 0) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("\n========== All Reservations ==========");
        for (int i = 0; i < numOfRes; i++) {
            System.out.println(reservations[i]);
        }
        System.out.println("======================================");
    }

    // ─── Recursive revenue calculation ─────────────────────────────────────

    public double calculateTotalRevenue() {
        return calculateTotalRevenue(0);
    }

    public double calculateTotalRevenue(int index) {
        if (index >= numOfRes) return 0.0;
        char stat = reservations[index].getStatus();
        double multiplier;
        switch (stat) {
            case 'F': multiplier = 1.0; break; // Finished = full payment
            case 'C': multiplier = 0.5; break; // Cancelled = 50% penalty
            case 'A': // Active = not yet paid
            case 'R': // Refunded = no revenue
            default:  multiplier = 0.0; break;
        }
        return reservations[index].calculatePrice() * multiplier + calculateTotalRevenue(index + 1);
    }
}
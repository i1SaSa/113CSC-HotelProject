public class HotelSystem {
    private Reservation[] reservations;
    private int numOfReservations;
    private Customer[] customers;
    private int numOfCustomers;

    public HotelSystem(int maxReservations, int maxCustomers) {
        this.reservations = new Reservation[maxReservations];
        this.numOfReservations = 0;
        this.customers = new Customer[maxCustomers];
        this.numOfCustomers = 0;
    }

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

    public boolean removeCustomer(String customerID) {
        for (int i = 0; i < numOfCustomers; i++) {
            if (customers[i].getCustomerID().equals(customerID)) {
                for (int j = i; j < numOfCustomers - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[numOfCustomers - 1] = null;
                numOfCustomers--;
                return true;
            }
        }
        System.out.println("Error: Customer with ID " + customerID + " not found.");
        return false;
    }

    public Customer searchCustomer(String customerID) {
        for (int i = 0; i < numOfCustomers; i++) {
            if (customers[i].getCustomerID().equals(customerID)) {
                return customers[i];
            }
        }
        return null;
    }

    // ─── Reservation methods ────────────────────────────────────────────────

    public boolean addReservation(Reservation reservation) {
        if (numOfReservations < reservations.length) {
            reservations[numOfReservations] = reservation;
            numOfReservations++;
            return true;
        }
        System.out.println("Error: Cannot add reservation. Maximum capacity reached.");
        return false;
    }

    public boolean removeReservation(String resID) {
        for (int i = 0; i < numOfReservations; i++) {
            if (reservations[i].getResID().equals(resID)) {
                for (int j = i; j < numOfReservations - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[numOfReservations - 1] = null;
                numOfReservations--;
                System.out.println("Reservation " + resID + " removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Reservation with ID " + resID + " not found.");
        return false;
    }

    public int searchReservation(String resID) {
        for (int i = 0; i < numOfReservations; i++) {
            if (reservations[i].getResID().equals(resID)) {
                return i;
            }
        }
        return -1;
    }

    public void displayAllReservations() {
        if (numOfReservations == 0) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("\n========== All Reservations ==========");
        for (int i = 0; i < numOfReservations; i++) {
            System.out.println(reservations[i]);
        }
        System.out.println("======================================");
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

    // ─── Recursive revenue calculation ─────────────────────────────────────

    public double calculateTotalRevenue() {
        return calculateTotalRevenue(0);
    }

    private double calculateTotalRevenue(int index) {
        if (index >= numOfReservations) {
            return 0.0;
        }
        char stat = reservations[index].getStatus();
        double multiplier;
        switch (stat) {
            case 'F': multiplier = 1.0;  break; // Finished = full payment
            case 'A': multiplier = 0.0;  break; // Active = not yet paid
            case 'C': multiplier = 0.5;  break; // Cancelled = 50% penalty
            case 'R': multiplier = 0.0;  break; // Refunded = no revenue
            default:   multiplier = 0.0;  break;
        }
        double revenue = reservations[index].calculatePrice() * multiplier;
        return revenue + calculateTotalRevenue(index + 1);
    }
}

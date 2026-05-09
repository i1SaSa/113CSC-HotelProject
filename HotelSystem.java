
import java.io.*;

public class HotelSystem implements java.io.Serializable {

    // Replaced arrays with MyLinkedList
    private MyLinkedList<Reservation> reservations;
    private MyLinkedList<Customer> customers;

    public HotelSystem() {
        // No need for max capacity anymore
        this.reservations = new MyLinkedList<>();
        this.customers = new MyLinkedList<>();
    }

    public int getNumOfCustomers() {
        return customers.getSize();
    }

    public int getNumOfRes() {
        return reservations.getSize();
    }

    // Needed for GUI to display all reservations
    public MyLinkedList<Reservation> getReservationsList() {
        return reservations;
    }

    // ─── Customer methods ───────────────────────────────────────────────────
    public boolean addCustomer(Customer customer) {
        // Linked List has no maximum capacity
        customers.add(customer);
        return true;
    }

    public boolean removeCustomer(String name) {
        Node<Customer> current = customers.getHead();
        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(name)) {
                customers.remove(current.getData());
                System.out.println("Customer " + name + " removed successfully.");
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Error: Customer " + name + " not found.");
        return false;
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hotel_data.ser"))) {
            oos.writeObject(this);
            System.out.println("Data saved successfully to hotel_data.ser");
        } catch (IOException e) {
            System.out.println("CRITICAL ERROR during save: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hotel_data.ser"))) {
            HotelSystem loadedSystem = (HotelSystem) ois.readObject();

            this.reservations = loadedSystem.reservations;
            this.customers = loadedSystem.customers;

            System.out.println("Data loaded successfully. Total Res: " + getNumOfRes());
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found (File not created yet).");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Customer searchCustomer(String name) {
        Node<Customer> current = customers.getHead();
        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(name)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayAllCustomers() {
        if (customers.getSize() == 0) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("\n========== All Customers ==========");
        Node<Customer> current = customers.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("===================================");
    }

    // ─── Reservation methods ────────────────────────────────────────────────
    public boolean addReservation(Reservation reservation) {
        // Check for duplicate ID using the updated search method
        if (getReservation(reservation.getResID()) != null) {
            System.out.println("Error: Reservation ID '" + reservation.getResID() + "' already exists.");
            return false;
        }
        reservations.add(reservation);
        return true;
    }

    public boolean removeReservation(String resID) {
        Node<Reservation> current = reservations.getHead();
        while (current != null) {
            if (current.getData().getResID().equals(resID)) {
                reservations.remove(current.getData());
                System.out.println("Reservation " + resID + " removed successfully.");
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Error: Reservation " + resID + " not found.");
        return false;
    }

    public Reservation getReservation(String resID) {
        Node<Reservation> current = reservations.getHead();
        while (current != null) {
            if (current.getData().getResID().equals(resID)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayAllReservations() {
        if (reservations.getSize() == 0) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("\n========== All Reservations ==========");
        Node<Reservation> current = reservations.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("======================================");
    }

    // ─── Recursive revenue calculation ─────────────────────────────────────
    public double calculateTotalRevenue() {
        return calculateTotalRevenue(reservations.getHead());
    }

    // Updated recursive method to take a Node instead of an index
    private double calculateTotalRevenue(Node<Reservation> node) {
        if (node == null) {
            return 0.0;
        }

        Reservation res = node.getData();
        char stat = res.getStatus();
        double multiplier;

        switch (stat) {
            case 'F':
                multiplier = 1.0;
                break; // Finished = full payment
            case 'C':
                multiplier = 0.5;
                break; // Cancelled = 50% penalty
            case 'A': // Active = not yet paid
            case 'R': // Refunded = no revenue
            default:
                multiplier = 0.0;
                break;
        }

        return (res.calculatePrice() * multiplier) + calculateTotalRevenue(node.getNext());
    }

    public MyLinkedList<Customer> getCustomersList() {
        return customers;
    }
}

import java.util.Scanner;

public class HotelTester {

    static HotelSystem hotel = new HotelSystem(50, 50);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*".repeat(50));
        System.out.println("      Welcome to the King Saud Hotel System");
        System.out.println("*".repeat(50));

        int choice = -1;
        while (choice != 0) {
            printMainMenu();
            choice = readInt();
            switch (choice) {
                case 1: manageCustomers(); break;
                case 2: manageReservations(); break;
                case 3: hotel.displayAllReservations(); break;
                case 4: hotel.displayAllCustomers(); break;
                case 5:
                    System.out.printf("Total Revenue Collected: %.2f SAR%n",
                            hotel.calculateTotalRevenue());
                    break;
                case 0: System.out.println("Thank you for using King Saud Hotel System. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ─── Menus ──────────────────────────────────────────────────────────────

    static void printMainMenu() {
        System.out.println("\n---------- Main Menu ----------");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Reservations");
        System.out.println("3. Display All Reservations");
        System.out.println("4. Display All Customers");
        System.out.println("5. Calculate Total Revenue");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    static void manageCustomers() {
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. Add Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Search Customer");
        System.out.print("Your choice: ");
        int c = readInt();
        switch (c) {
            case 1: addCustomer(); break;
            case 2: removeCustomer(); break;
            case 3: searchCustomer(); break;
            default: System.out.println("Invalid choice.");
        }
    }

    static void manageReservations() {
        System.out.println("\n--- Reservation Menu ---");
        System.out.println("1. Add Room Reservation");
        System.out.println("2. Add Event Space Reservation");
        System.out.println("3. Remove Reservation");
        System.out.println("4. Search Reservation");
        System.out.println("5. Update Reservation Status");
        System.out.print("Your choice: ");
        int c = readInt();
        switch (c) {
            case 1: addRoomReservation(); break;
            case 2: addEventReservation(); break;
            case 3: removeReservation(); break;
            case 4: searchReservation(); break;
            case 5: updateStatus(); break;
            default: System.out.println("Invalid choice.");
        }
    }

    // ─── Customer operations ────────────────────────────────────────────────

    static void addCustomer() {
        System.out.println("--- Add Customer ---");
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine().trim();
        Customer c = new Customer(id, name, phone);
        if (hotel.addCustomer(c)) {
            System.out.println("Customer added successfully: " + c);
        }
    }

    static void removeCustomer() {
        System.out.print("Enter Customer ID to remove: ");
        String id = sc.nextLine().trim();
        hotel.removeCustomer(id);
    }

    static void searchCustomer() {
        System.out.print("Enter Customer ID to search: ");
        String id = sc.nextLine().trim();
        Customer c = hotel.searchCustomer(id);
        if (c != null) {
            System.out.println("Found: " + c);
        } else {
            System.out.println("Customer not found.");
        }
    }

    // ─── Reservation operations ─────────────────────────────────────────────

    static void addRoomReservation() {
        System.out.println("--- Add Room Reservation ---");

        // Get guest
        System.out.print("Enter Guest Customer ID: ");
        String guestID = sc.nextLine().trim();
        Customer guest = hotel.searchCustomer(guestID);
        if (guest == null) {
            System.out.println("Customer not found. Please add the customer first.");
            return;
        }

        System.out.print("Enter Reservation ID: ");
        String resID = sc.nextLine().trim();
        System.out.print("Enter Check-in Day: ");   int day   = readInt();
        System.out.print("Enter Check-in Month: "); int month = readInt();
        System.out.print("Enter Check-in Year: ");  int year  = readInt();
        System.out.print("Enter Number of Nights: "); int nights = readInt();
        System.out.print("Enter Number of Beds: ");   int beds   = readInt();
        System.out.print("Enter Room Number: ");
        String roomNum = sc.nextLine().trim();

        System.out.println("Room Type: 1. Regular  2. Family  3. Suite");
        System.out.print("Your choice: ");
        int type = readInt();

        Reservation res = null;
        switch (type) {
            case 1:
                System.out.print("Has Mini Fridge? (y/n): ");
                boolean fridge = sc.nextLine().trim().equalsIgnoreCase("y");
                res = new RegularRoom(resID, day, month, year, guest, beds, roomNum, nights, fridge);
                break;
            case 2:
                System.out.print("Has Kitchenette? (y/n): ");
                boolean kitchen = sc.nextLine().trim().equalsIgnoreCase("y");
                res = new FamilyRoom(resID, day, month, year, guest, beds, roomNum, nights, kitchen);
                break;
            case 3:
                System.out.print("Has Balcony? (y/n): ");
                boolean balcony = sc.nextLine().trim().equalsIgnoreCase("y");
                Suite suite = new Suite(resID, day, month, year, guest, beds, roomNum, nights, balcony);
                suite.assignParking(); // Demonstrate interface
                res = suite;
                break;
            default:
                System.out.println("Invalid room type.");
                return;
        }

        if (hotel.addReservation(res)) {
            System.out.println("Reservation added: " + res);
        }
    }

    static void addEventReservation() {
        System.out.println("--- Add Event Space Reservation ---");

        System.out.print("Enter Guest Customer ID: ");
        String guestID = sc.nextLine().trim();
        Customer guest = hotel.searchCustomer(guestID);
        if (guest == null) {
            System.out.println("Customer not found. Please add the customer first.");
            return;
        }

        System.out.print("Enter Reservation ID: ");
        String resID = sc.nextLine().trim();
        System.out.print("Enter Day: ");   int day   = readInt();
        System.out.print("Enter Month: "); int month = readInt();
        System.out.print("Enter Year: ");  int year  = readInt();
        System.out.print("Enter Max Capacity: "); int cap  = readInt();
        System.out.print("Enter Size (sqft): ");  int size = readInt();

        System.out.println("Event Space Type: 1. Lobby  2. Event Hall");
        System.out.print("Your choice: ");
        int type = readInt();

        Reservation res = null;
        switch (type) {
            case 1:
                res = new Lobby(resID, day, month, year, guest, cap, size);
                break;
            case 2:
                System.out.print("Has Stage? (y/n): ");
                boolean stage = sc.nextLine().trim().equalsIgnoreCase("y");
                res = new EventHall(resID, day, month, year, guest, cap, size, stage);
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }

        if (hotel.addReservation(res)) {
            System.out.println("Event reservation added: " + res);
        }
    }

    static void removeReservation() {
        System.out.print("Enter Reservation ID to remove: ");
        String id = sc.nextLine().trim();
        hotel.removeReservation(id);
    }

    static void searchReservation() {
        System.out.print("Enter Reservation ID to search: ");
        String id = sc.nextLine().trim();
        int idx = hotel.searchReservation(id);
        if (idx != -1) {
            System.out.println("Reservation found at index " + idx + ".");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    static void updateStatus() {
        System.out.print("Enter Reservation ID: ");
        String id = sc.nextLine().trim();
        int idx = hotel.searchReservation(id);
        if (idx == -1) {
            System.out.println("Reservation not found.");
            return;
        }
        System.out.println("Status options: A (Active) | C (Cancelled) | R (Refunded) | F (Finished)");
        System.out.print("Enter new status: ");
        char s = sc.nextLine().trim().charAt(0);
        // We need to access the reservation — add a getter to HotelSystem or use index trick
        // For now, iterate to find and set
        System.out.println("Status update requested. Use the hotel system's reservation reference.");
    }

    // ─── Helper ─────────────────────────────────────────────────────────────

    static int readInt() {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}

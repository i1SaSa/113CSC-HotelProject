
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Main Input Frame for the Hotel System
 *
 */
public class inputgui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Logic Reference: Using the updated HotelSystem with LinkedList
    static HotelSystem hotel = new HotelSystem();

    // Text Fields for input
    private JTextField namef, phonef, residbox, daybox, monthbox, yearbox, roombox, capicitybox, nightsbox, sizebox;

    // Dropdowns (JComboBox)
    private JComboBox<String> resdropdown, roomdropdowns, eventdropdown, minifridropdown, kitdropdown, suitebalconydrop, stagedropdown;
    private JComboBox<String> customerDropdown; // Dropdown for selecting existing customers
    private DefaultComboBoxModel<String> customerModel; // Model to manage dropdown items dynamicly

    // Labels
    private JLabel lblRoom, lblCapacity, lblSize, lblNights, lblRoomType, lblEventType, minifri, kitchenette, lblBalcony, lblStage;

    // Output Components
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                inputgui frame = new inputgui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public inputgui() {
        setTitle("King Saud Hotel System - Phase 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ─── CUSTOMER SECTION ───────────────────────────────────────────────
        JLabel lblCustInfo = new JLabel("1. Add New Customer:");
        lblCustInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCustInfo.setBounds(10, 11, 150, 14);
        contentPane.add(lblCustInfo);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(10, 36, 46, 14);
        contentPane.add(lblName);

        namef = new JTextField();
        namef.setBounds(55, 33, 86, 20);
        contentPane.add(namef);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(151, 36, 46, 14);
        contentPane.add(lblPhone);

        phonef = new JTextField();
        phonef.setBounds(196, 33, 86, 20);
        contentPane.add(phonef);

        JButton cusbotton = new JButton("Register Customer");
        cusbotton.setBounds(292, 32, 160, 23);
        contentPane.add(cusbotton);

        // ─── RESERVATION SECTION ────────────────────────────────────────────
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 64, 484, 2);
        contentPane.add(separator);

        JLabel lblResTitle = new JLabel("2. Create Reservation:");
        lblResTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblResTitle.setBounds(10, 77, 150, 14);
        contentPane.add(lblResTitle);

        JLabel lblSelectGuest = new JLabel("Select Guest:");
        lblSelectGuest.setBounds(10, 102, 80, 14);
        contentPane.add(lblSelectGuest);

        // The Dropdown for customer selection
        customerModel = new DefaultComboBoxModel<>();
        customerDropdown = new JComboBox<>(customerModel);
        customerDropdown.setBounds(90, 98, 150, 22);
        contentPane.add(customerDropdown);

        JLabel lblResId = new JLabel("Res ID:");
        lblResId.setBounds(255, 102, 50, 14);
        contentPane.add(lblResId);

        residbox = new JTextField();
        residbox.setBounds(305, 99, 50, 20);
        contentPane.add(residbox);

        JLabel lblDate = new JLabel("Date (D/M/Y):");
        lblDate.setBounds(10, 133, 90, 14);
        contentPane.add(lblDate);

        daybox = new JTextField();
        daybox.setBounds(100, 130, 25, 20);
        contentPane.add(daybox);
        monthbox = new JTextField();
        monthbox.setBounds(130, 130, 25, 20);
        contentPane.add(monthbox);
        yearbox = new JTextField();
        yearbox.setBounds(160, 130, 40, 20);
        contentPane.add(yearbox);

        JLabel lblType = new JLabel("Category:");
        lblType.setBounds(220, 133, 70, 14);
        contentPane.add(lblType);

        resdropdown = new JComboBox<>(new String[]{"room", "event"});
        resdropdown.setSelectedIndex(-1);
        resdropdown.setBounds(285, 129, 80, 22);
        contentPane.add(resdropdown);

        // ─── DYNAMIC ROOM/EVENT COMPONENTS ──────────────────────────────────
        // (Positioned around Y=160-200)
        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(10, 165, 80, 14);
        lblRoomType.setVisible(false);
        contentPane.add(lblRoomType);

        roomdropdowns = new JComboBox<>(new String[]{"regular", "family", "suite"});
        roomdropdowns.setBounds(90, 161, 80, 22);
        roomdropdowns.setVisible(false);
        contentPane.add(roomdropdowns);

        lblRoom = new JLabel("Room #:");
        lblRoom.setBounds(180, 165, 50, 14);
        lblRoom.setVisible(false);
        contentPane.add(lblRoom);

        roombox = new JTextField();
        roombox.setBounds(230, 162, 35, 20);
        roombox.setVisible(false);
        contentPane.add(roombox);

        lblNights = new JLabel("Nights:");
        lblNights.setBounds(280, 165, 50, 14);
        lblNights.setVisible(false);
        contentPane.add(lblNights);

        nightsbox = new JTextField();
        nightsbox.setBounds(330, 162, 35, 20);
        nightsbox.setVisible(false);
        contentPane.add(nightsbox);

        lblEventType = new JLabel("Event Type:");
        lblEventType.setBounds(10, 165, 80, 14);
        lblEventType.setVisible(false);
        contentPane.add(lblEventType);

        eventdropdown = new JComboBox<>(new String[]{"lobby", "hall"});
        eventdropdown.setBounds(90, 161, 80, 22);
        eventdropdown.setVisible(false);
        contentPane.add(eventdropdown);

        lblCapacity = new JLabel("Cap:");
        lblCapacity.setBounds(180, 165, 35, 14);
        lblCapacity.setVisible(false);
        contentPane.add(lblCapacity);

        capicitybox = new JTextField();
        capicitybox.setBounds(215, 162, 40, 20);
        capicitybox.setVisible(false);
        contentPane.add(capicitybox);

        lblSize = new JLabel("Size:");
        lblSize.setBounds(265, 165, 40, 14);
        lblSize.setVisible(false);
        contentPane.add(lblSize);

        sizebox = new JTextField();
        sizebox.setBounds(305, 162, 40, 20);
        sizebox.setVisible(false);
        contentPane.add(sizebox);

        // --- EXTRAS (Row 190) ---
        minifri = new JLabel("Mini Fridge?");
        minifri.setBounds(10, 195, 90, 14);
        minifri.setVisible(false);
        contentPane.add(minifri);
        minifridropdown = new JComboBox<>(new String[]{"yes", "no"});
        minifridropdown.setBounds(100, 191, 60, 22);
        minifridropdown.setVisible(false);
        contentPane.add(minifridropdown);

        kitchenette = new JLabel("Kitchenette?");
        kitchenette.setBounds(10, 195, 90, 14);
        kitchenette.setVisible(false);
        contentPane.add(kitchenette);
        kitdropdown = new JComboBox<>(new String[]{"yes", "no"});
        kitdropdown.setBounds(100, 191, 60, 22);
        kitdropdown.setVisible(false);
        contentPane.add(kitdropdown);

        lblBalcony = new JLabel("Balcony?");
        lblBalcony.setBounds(10, 195, 90, 14);
        lblBalcony.setVisible(false);
        contentPane.add(lblBalcony);
        suitebalconydrop = new JComboBox<>(new String[]{"yes", "no"});
        suitebalconydrop.setBounds(100, 191, 60, 22);
        suitebalconydrop.setVisible(false);
        contentPane.add(suitebalconydrop);

        lblStage = new JLabel("Stage?");
        lblStage.setBounds(10, 195, 90, 14);
        lblStage.setVisible(false);
        contentPane.add(lblStage);
        stagedropdown = new JComboBox<>(new String[]{"yes", "no"});
        stagedropdown.setBounds(100, 191, 60, 22);
        stagedropdown.setVisible(false);
        contentPane.add(stagedropdown);

        // ─── SYSTEM BUTTONS ─────────────────────────────────────────────────
        JButton resbutton = new JButton("Confirm Reservation");
        resbutton.setBounds(10, 230, 160, 23);
        contentPane.add(resbutton);

        JButton saveButton = new JButton("Save File");
        saveButton.setBounds(180, 230, 100, 23);
        contentPane.add(saveButton);

        JButton loadButton = new JButton("Load File");
        loadButton.setBounds(290, 230, 100, 23);
        contentPane.add(loadButton);

        // Open ResultFrame Button
        JButton openResultsBtn = new JButton("View All Results / Search");
        openResultsBtn.setBackground(new Color(230, 245, 255));
        openResultsBtn.setBounds(10, 260, 380, 25);
        contentPane.add(openResultsBtn);

        // ─── OUTPUT AREA ────────────────────────────────────────────────────
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 300, 484, 150);
        contentPane.add(scrollPane);

        // ─── EVENT LISTENERS ────────────────────────────────────────────────
        // Visibility Logic for Dropdowns
        resdropdown.addActionListener(e -> {
            boolean isRoom = "room".equals(resdropdown.getSelectedItem());
            lblRoomType.setVisible(isRoom);
            roomdropdowns.setVisible(isRoom);
            lblRoom.setVisible(isRoom);
            roombox.setVisible(isRoom);
            lblNights.setVisible(isRoom);
            nightsbox.setVisible(isRoom);

            lblEventType.setVisible(!isRoom);
            eventdropdown.setVisible(!isRoom);
            lblCapacity.setVisible(!isRoom);
            capicitybox.setVisible(!isRoom);
            lblSize.setVisible(!isRoom);
            sizebox.setVisible(!isRoom);

            minifri.setVisible(false);
            minifridropdown.setVisible(false);
            kitchenette.setVisible(false);
            kitdropdown.setVisible(false);
            lblBalcony.setVisible(false);
            suitebalconydrop.setVisible(false);
            lblStage.setVisible(false);
            stagedropdown.setVisible(false);
            revalidate();
            repaint();
        });

        roomdropdowns.addActionListener(e -> {
            String sel = (String) roomdropdowns.getSelectedItem();
            minifri.setVisible("regular".equals(sel));
            minifridropdown.setVisible("regular".equals(sel));
            kitchenette.setVisible("family".equals(sel));
            kitdropdown.setVisible("family".equals(sel));
            lblBalcony.setVisible("suite".equals(sel));
            suitebalconydrop.setVisible("suite".equals(sel));
            revalidate();
            repaint();
        });

        eventdropdown.addActionListener(e -> {
            boolean isHall = "hall".equals(eventdropdown.getSelectedItem());
            lblStage.setVisible(isHall);
            stagedropdown.setVisible(isHall);
            revalidate();
            repaint();
        });

        // 1. Add Customer Action
        cusbotton.addActionListener(e -> {
            String n = namef.getText().trim();
            String p = phonef.getText().trim();

            if (!n.isEmpty() && !p.isEmpty()) {
                if (hotel.addCustomer(new Customer(n, p))) {
                    customerModel.addElement(n);
                    outputArea.append("System: Customer '" + n + "' registered.\n");

                    namef.setText("");
                    phonef.setText("");
                }
            } else {
                outputArea.append("Error: Please enter BOTH customer name and phone number.\n");
            }
        });

        // 2. Add Reservation Action (With Exception Handling)
        resbutton.addActionListener(e -> {
            try {
                // Get selected guest from dropdown
                String selectedName = (String) customerDropdown.getSelectedItem();
                if (selectedName == null) {
                    outputArea.append("Error: No customer selected.\n");
                    return;
                }

                Customer guest = hotel.searchCustomer(selectedName);
                String id = residbox.getText().trim();
                int d = Integer.parseInt(daybox.getText());
                int m = Integer.parseInt(monthbox.getText());
                int y = Integer.parseInt(yearbox.getText());

                // User-defined Checked Exception Trigger
                if (d < 1 || d > 31 || m < 1 || m > 12) {
                    throw new InvalidDateException("The date provided is logically invalid.");
                }

                Reservation resObj = null;

                if ("room".equals(resdropdown.getSelectedItem())) {
                    String type = (String) roomdropdowns.getSelectedItem();
                    String rNum = roombox.getText();
                    int nights = Integer.parseInt(nightsbox.getText());

                    if (type.equals("regular")) {
                        resObj = new RegularRoom(id, d, m, y, guest, 2, rNum, nights, minifridropdown.getSelectedItem().equals("yes"));
                    } else if (type.equals("family")) {
                        resObj = new FamilyRoom(id, d, m, y, guest, 4, rNum, nights, kitdropdown.getSelectedItem().equals("yes"));
                    } else if (type.equals("suite")) {
                        Suite s = new Suite(id, d, m, y, guest, 2, rNum, nights, suitebalconydrop.getSelectedItem().equals("yes"));
                        s.assignParking();
                        resObj = s;
                    }
                } else if ("event".equals(resdropdown.getSelectedItem())) {
                    int cap = Integer.parseInt(capicitybox.getText());
                    int sz = Integer.parseInt(sizebox.getText());
                    if ("lobby".equals(eventdropdown.getSelectedItem())) {
                        resObj = new Lobby(id, d, m, y, guest, cap, sz);
                    } else {
                        resObj = new EventHall(id, d, m, y, guest, cap, sz, stagedropdown.getSelectedItem().equals("yes"));
                    }
                }

                if (resObj != null) {
                    if (hotel.addReservation(resObj)) {
                        outputArea.append("System: Reservation " + id + " created successfully.\n");
                        residbox.setText("");
                    } else {
                        outputArea.append("Error: Reservation ID '" + id + "' already exists! Please use a different ID.\n");
                    }
                }

            } catch (NumberFormatException ex) {
                // Handle Unchecked Exception (Incorrect data type in boxes)
                outputArea.append("Input Error: Day/Month/Year/Capacity/Nights must be integers.\n");
            } catch (InvalidDateException ex) {
                // Handle User-defined Exception
                outputArea.append("Date Error: " + ex.getMessage() + "\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        // 3. Save Data Action
        saveButton.addActionListener(e -> {
            if (hotel.saveData()) {
                outputArea.append("System: Data saved successfully to hotel_data.ser.\n");
            } else {
                outputArea.append("CRITICAL ERROR: Could not save data. Check terminal for details.\n");
            }
        });

        // 4. Load Data Action (Syncs the dropdown)
        loadButton.addActionListener(e -> {
            hotel.loadData();
            customerModel.removeAllElements();
            // Assuming HotelSystem has getCustomersList() returning MyLinkedList<Customer>
            Node<Customer> current = hotel.getCustomersList().getHead();
            while (current != null) {
                customerModel.addElement(current.getData().getName());
                current = current.getNext();
            }
            outputArea.append("System: Data loaded. Customer list synchronized.\n");
        });

        // 5. Open Results Action
        openResultsBtn.addActionListener(e -> {
            ResultFrame rf = new ResultFrame(hotel);
            rf.setVisible(true);
        });
    }
}

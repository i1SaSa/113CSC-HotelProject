

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputgui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Logic Reference (Ensure HotelSystem class is in your project)
    static HotelSystem hotel = new HotelSystem(50, 50);

    // Text Fields
    private JTextField namef, phonef, residbox, daybox, monthbox, yearbox, roombox, capicitybox, nightsbox, sizebox;
    
    // Dropdowns and Labels
    private JComboBox resdropdown, roomdropdowns, eventdropdown, minifridropdown, kitdropdown, suitebalconydrop, stagedropdown;
    private JLabel lblRoom, lblCapacity, lblSize, lblNights, lblRoomType, lblEventType, minifri, kitchenette, lblBalcony, lblStage;
    
    // Output Component
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- CUSTOMER SECTION ---
        JLabel lblCust = new JLabel("Customer Info:");
        lblCust.setBounds(10, 20, 110, 14);
        contentPane.add(lblCust);

        namef = new JTextField();
        namef.setBounds(110, 17, 70, 20);
        contentPane.add(namef);
        
        phonef = new JTextField();
        phonef.setBounds(190, 17, 70, 20);
        contentPane.add(phonef);

        JButton cusbotton = new JButton("Add Cust");
        cusbotton.setBounds(270, 16, 90, 23);
        contentPane.add(cusbotton);

        // --- RESERVATION BASE INFO ---
        JLabel lblResId = new JLabel("Res ID:");
        lblResId.setBounds(10, 60, 50, 14);
        contentPane.add(lblResId);

        residbox = new JTextField();
        residbox.setBounds(60, 57, 40, 20);
        contentPane.add(residbox);

        JLabel lblDate = new JLabel("Date (D/M/Y):");
        lblDate.setBounds(110, 60, 90, 14);
        contentPane.add(lblDate);

        daybox = new JTextField(); daybox.setBounds(200, 57, 25, 20); contentPane.add(daybox);
        monthbox = new JTextField(); monthbox.setBounds(230, 57, 25, 20); contentPane.add(monthbox);
        yearbox = new JTextField(); yearbox.setBounds(260, 57, 40, 20); contentPane.add(yearbox);

        // --- TYPE SELECTION ---
        JLabel res = new JLabel("Res Type:");
        res.setBounds(10, 100, 70, 14);
        contentPane.add(res);

        resdropdown = new JComboBox(new String[] {"room", "event"});
        resdropdown.setSelectedIndex(-1);
        resdropdown.setBounds(80, 96, 70, 22);
        contentPane.add(resdropdown);

        // --- DYNAMIC ROOM COMPONENTS ---
        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(10, 130, 80, 14);
        lblRoomType.setVisible(false);
        contentPane.add(lblRoomType);

        roomdropdowns = new JComboBox(new String[] {"regular", "family", "suite"});
        roomdropdowns.setBounds(90, 126, 80, 22);
        roomdropdowns.setVisible(false);
        contentPane.add(roomdropdowns);

        lblRoom = new JLabel("Room #:");
        lblRoom.setBounds(180, 100, 50, 14);
        lblRoom.setVisible(false);
        contentPane.add(lblRoom);

        roombox = new JTextField();
        roombox.setBounds(230, 97, 35, 20);
        roombox.setVisible(false);
        contentPane.add(roombox);

        lblNights = new JLabel("Nights:");
        lblNights.setBounds(280, 100, 50, 14);
        lblNights.setVisible(false);
        contentPane.add(lblNights);

        nightsbox = new JTextField();
        nightsbox.setBounds(330, 97, 35, 20);
        nightsbox.setVisible(false);
        contentPane.add(nightsbox);

        // --- DYNAMIC EVENT COMPONENTS ---
        lblEventType = new JLabel("Event Type:");
        lblEventType.setBounds(10, 130, 80, 14);
        lblEventType.setVisible(false);
        contentPane.add(lblEventType);

        eventdropdown = new JComboBox(new String[] {"lobby", "hall"});
        eventdropdown.setBounds(90, 126, 80, 22);
        eventdropdown.setVisible(false);
        contentPane.add(eventdropdown);

        lblCapacity = new JLabel("Cap:");
        lblCapacity.setBounds(180, 100, 35, 14);
        lblCapacity.setVisible(false);
        contentPane.add(lblCapacity);

        capicitybox = new JTextField();
        capicitybox.setBounds(215, 97, 40, 20);
        capicitybox.setVisible(false);
        contentPane.add(capicitybox);

        lblSize = new JLabel("Size:");
        lblSize.setBounds(265, 100, 40, 14);
        lblSize.setVisible(false);
        contentPane.add(lblSize);

        sizebox = new JTextField();
        sizebox.setBounds(305, 97, 40, 20);
        sizebox.setVisible(false);
        contentPane.add(sizebox);

        // --- EXTRAS (Row 160) ---
        minifri = new JLabel("Add Fridge?");
        minifri.setBounds(10, 160, 90, 14);
        minifri.setVisible(false);
        contentPane.add(minifri);

        minifridropdown = new JComboBox(new String[] {"yes", "no"});
        minifridropdown.setBounds(100, 156, 60, 22);
        minifridropdown.setVisible(false);
        contentPane.add(minifridropdown);

        kitchenette = new JLabel("Kitchenette?");
        kitchenette.setBounds(10, 160, 90, 14);
        kitchenette.setVisible(false);
        contentPane.add(kitchenette);

        kitdropdown = new JComboBox(new String[] {"yes", "no"});
        kitdropdown.setBounds(100, 156, 60, 22);
        kitdropdown.setVisible(false);
        contentPane.add(kitdropdown);

        lblBalcony = new JLabel("Balcony?");
        lblBalcony.setBounds(10, 160, 90, 14);
        lblBalcony.setVisible(false);
        contentPane.add(lblBalcony);

        suitebalconydrop = new JComboBox(new String[] {"yes", "no"});
        suitebalconydrop.setBounds(100, 156, 60, 22);
        suitebalconydrop.setVisible(false);
        contentPane.add(suitebalconydrop);

        lblStage = new JLabel("Stage?");
        lblStage.setBounds(10, 160, 90, 14);
        lblStage.setVisible(false);
        contentPane.add(lblStage);

        stagedropdown = new JComboBox(new String[] {"yes", "no"});
        stagedropdown.setBounds(100, 156, 60, 22);
        stagedropdown.setVisible(false);
        contentPane.add(stagedropdown);

        // --- OUTPUT AREA ---
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 240, 440, 160);
        contentPane.add(scrollPane);

        JButton resbutton = new JButton("Add Reservation");
        resbutton.setBounds(10, 200, 150, 23);
        contentPane.add(resbutton);

        // --- VISIBILITY LOGIC ---
        resdropdown.addActionListener(e -> {
            boolean isRoom = "room".equals(resdropdown.getSelectedItem());
            lblRoomType.setVisible(isRoom); roomdropdowns.setVisible(isRoom);
            lblRoom.setVisible(isRoom); roombox.setVisible(isRoom);
            lblNights.setVisible(isRoom); nightsbox.setVisible(isRoom);
            
            lblEventType.setVisible(!isRoom); eventdropdown.setVisible(!isRoom);
            lblCapacity.setVisible(!isRoom); capicitybox.setVisible(!isRoom);
            lblSize.setVisible(!isRoom); sizebox.setVisible(!isRoom);
            
            // Clear extras
            minifri.setVisible(false); minifridropdown.setVisible(false);
            kitchenette.setVisible(false); kitdropdown.setVisible(false);
            lblBalcony.setVisible(false); suitebalconydrop.setVisible(false);
            lblStage.setVisible(false); stagedropdown.setVisible(false);
            revalidate(); repaint();
        });

        roomdropdowns.addActionListener(e -> {
            String sel = (String) roomdropdowns.getSelectedItem();
            minifri.setVisible("regular".equals(sel)); minifridropdown.setVisible("regular".equals(sel));
            kitchenette.setVisible("family".equals(sel)); kitdropdown.setVisible("family".equals(sel));
            lblBalcony.setVisible("suite".equals(sel)); suitebalconydrop.setVisible("suite".equals(sel));
            revalidate(); repaint();
        });

        eventdropdown.addActionListener(e -> {
            boolean isHall = "hall".equals(eventdropdown.getSelectedItem());
            lblStage.setVisible(isHall); stagedropdown.setVisible(isHall);
            revalidate(); repaint();
        });

        // --- FUNCTIONALITY ---
        cusbotton.addActionListener(e -> {
            String n = namef.getText().trim();
            String p = phonef.getText().trim();
            if(!n.isEmpty() && hotel.addCustomer(new Customer(n, p))) {
                outputArea.append("Success: Customer " + n + " added.\n");
            } else {
                outputArea.append("Error: Could not add customer.\n");
            }
        });

        resbutton.addActionListener(e -> {
            try {
                Customer guest = hotel.searchCustomer(namef.getText().trim());
                if (guest == null) { outputArea.append("Error: Customer not found.\n"); return; }

                String id = residbox.getText();
                int d = Integer.parseInt(daybox.getText());
                int m = Integer.parseInt(monthbox.getText());
                int y = Integer.parseInt(yearbox.getText());
                Reservation resObj = null;

                if ("room".equals(resdropdown.getSelectedItem())) {
                    String type = (String) roomdropdowns.getSelectedItem();
                    String rNum = roombox.getText();
                    int nights = Integer.parseInt(nightsbox.getText());

                    if (type.equals("regular")) resObj = new RegularRoom(id, d, m, y, guest, 2, rNum, nights, minifridropdown.getSelectedItem().equals("yes"));
                    else if (type.equals("family")) resObj = new FamilyRoom(id, d, m, y, guest, 4, rNum, nights, kitdropdown.getSelectedItem().equals("yes"));
                    else if (type.equals("suite")) {
                        Suite s = new Suite(id, d, m, y, guest, 2, rNum, nights, suitebalconydrop.getSelectedItem().equals("yes"));
                        s.assignParking(); 
                        resObj = s;
                    }
                } else {
                    int cap = Integer.parseInt(capicitybox.getText());
                    int size = Integer.parseInt(sizebox.getText());
                    if ("lobby".equals(eventdropdown.getSelectedItem())) resObj = new Lobby(id, d, m, y, guest, cap, size);
                    else resObj = new EventHall(id, d, m, y, guest, cap, size, stagedropdown.getSelectedItem().equals("yes"));
                }

                if (resObj != null && hotel.addReservation(resObj)) outputArea.append("Success: Res " + id + " added.\n");
                    else outputArea.append("Error: Could not add reservation.\n");
            } catch (Exception ex) {
                outputArea.append("Input Error: Check numbers/dates.\n");
            }
        });
    }
}

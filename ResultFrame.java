
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrame extends JFrame {

    private JTextArea displayArea;
    private JTextField searchField;
    private JButton searchBtn;
    private JButton displayAllBtn;
    private HotelSystem hotel; // Reference to the main system

    public ResultFrame(HotelSystem hotel) {
        this.hotel = hotel;

        // Basic frame setup
        setTitle("Hotel System - Results");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top panel (Search area)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Reservation ID:"));
        searchField = new JTextField(15);
        topPanel.add(searchField);

        searchBtn = new JButton("Search");
        displayAllBtn = new JButton("Display All");
        topPanel.add(searchBtn);
        topPanel.add(displayAllBtn);

        add(topPanel, BorderLayout.NORTH);

        // Center area (Display results)
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // ---------------------------------------------------------
        // Action Events + Unchecked Exception Handling (try/catch)
        // ---------------------------------------------------------
        // Search Button Action
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputId = searchField.getText().trim();

                    // Throwing an Unchecked Exception if the field is empty
                    if (inputId.isEmpty()) {
                        throw new IllegalArgumentException("Search field cannot be empty!");
                    }

                    // Call search method from the system
                    Reservation res = hotel.getReservation(inputId);
                    if (res != null) {
                        displayArea.setText("Reservation found:\n\n" + res.toString());
                    } else {
                        displayArea.setText("Sorry, no reservation found with ID: " + inputId);
                    }

                } catch (IllegalArgumentException ex) {
                    // Handling the exception in the same method
                    JOptionPane.showMessageDialog(ResultFrame.this,
                            ex.getMessage(),
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Display All Button Action
        displayAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("--- All Reservations in the System ---\n\n");

                // Assuming hotel system returns the custom linked list
                Node<Reservation> current = hotel.getReservationsList().getHead();
                if (current == null) {
                    displayArea.append("No reservations currently available.");
                } else {
                    while (current != null) {
                        displayArea.append(current.getData().toString() + "\n");
                        current = current.getNext();
                    }
                }
            }
        });
    }
}

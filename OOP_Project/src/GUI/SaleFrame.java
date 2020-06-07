package GUI;

import Backend.System.Model.Client;
import Backend.System.Model.Event;
import Backend.System.Model.Sales;
import Backend.System.Model.Ticket;
import Backend.System.Services.SalesServices;
import Backend.System.Services.TicketServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleFrame extends JFrame implements ActionListener {

    private SalesServices salesServices;
    private TicketServices ticketServices;
    private JLabel name;
    private JTextField nameField;
    private JLabel age;
    private JTextField ageField;
    private JButton submitButton;
    private Event event;

    public SaleFrame(Event event) {
        super("Sale Window");
        this.event = event;
        this.salesServices = new SalesServices();
        this.ticketServices = new TicketServices();

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4, 1));
        GridBagLayout layout = new GridBagLayout();
        this.pack();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        name = new JLabel("Name");
        JPanel namePanel = new JPanel();
        namePanel.setLayout(layout);
        namePanel.add(name, constraints);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, 20));
        namePanel.add(nameField, constraints);

        age = new JLabel("Age");
        JPanel agePanel = new JPanel();
        agePanel.setLayout(layout);
        agePanel.add(age, constraints);

        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(100, 20));
        agePanel.add(ageField, constraints);

        submitButton = new JButton("Submit");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(layout);
        buttonPanel.add(submitButton, constraints);

        pane.add(namePanel);
        pane.add(agePanel);
        pane.add(buttonPanel);

        submitButton.addActionListener(this);
        submitButton.setActionCommand("Submit");

        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(400, 250));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Submit")) {
            if(nameField.getText().equals("") || ageField.getText().equals("")) {
                JOptionPane.showMessageDialog(this,
                        "Name and Age must be provided.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                Ticket ticket = new Ticket(event);
                Client client = new Client(nameField.getText(), Integer.parseInt(ageField.getText()));
                ticketServices.insertTicket(ticket);
                salesServices.addSale(new Sales(ticket, client));
                JOptionPane.showMessageDialog(this, "Sale is registered!");
            }
        }
    }
}

package GUI;

import Backend.App.App;
import Backend.JDBC.JdbcConnection;
import Backend.System.Model.Event;
import Backend.System.Services.EventServices;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class AppFrame extends JFrame implements WindowListener, ListSelectionListener, ActionListener {

    private boolean appClosed;
    private JButton SaleButton;
    private JList<Event> eventList;

    public AppFrame() {
        super("Main Window");
        addWindowListener(this);
        Container pane = this.getContentPane();

        EventServices eventServices = new EventServices();
        eventList = new JList<Event>(new Vector<Event>(eventServices.getEvents()));
        eventList.setVisibleRowCount(10);
        JPanel ButtonPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(eventList);
        pane.add(scrollPane, BorderLayout.PAGE_START);

        SaleButton = new JButton("Get Ticket");
        SaleButton.setEnabled(false);
        ButtonPanel.add(SaleButton);
        pane.add(ButtonPanel, BorderLayout.CENTER);

        eventList.addListSelectionListener(this);
        SaleButton.addActionListener(this);
        SaleButton.setActionCommand("Get Ticket");

        this.setSize(400,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        appClosed = false;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("App is closing");;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        appClosed = true;
        App.closeConnection();

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("App is iconified.");;
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("App is back to normal.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("App is activated.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("App is deactivated.");
    }

    public boolean isAppClosed() {
        return appClosed;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        SaleButton.setEnabled(eventList.getSelectedIndex() != -1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals( "Get Ticket")) {
            System.out.println("Button Pressed");
            SaleFrame saleFrame = new SaleFrame(eventList.getSelectedValue());
        }
    }
}

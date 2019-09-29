package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Person {
    JPanel Person;
    private JButton ticket;
    private JButton passenger;
    private JButton flight;

    public Person()
     {
             ticket.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                         JPanel tic = new personTicket().InformTicket;
                         JFrame frame = new JFrame("Person Ticket");
                         frame.setContentPane(new personTicket().InformTicket);
                         frame.pack();
                         frame.setVisible(true);
                 }
             });
             passenger.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     JPanel pas = new personPassenger().InformPassenger;
                     JFrame frame = new JFrame("Information Passenger");
                     frame.setContentPane(new personPassenger().InformPassenger);
                     frame.pack();
                     frame.setVisible(true);
                 }
             });
             flight.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     JPanel info = new personFlight().flight;
                     JFrame frame = new JFrame("Person Flight");
                     frame.setContentPane(new personFlight().flight);
                     frame.pack();
                     frame.setVisible(true);
                 }
             });
     }
}

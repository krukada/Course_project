package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {
    JPanel Admin;
    private JButton root;
    private JButton ticketPass;

    public Admin(){
        ticketPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pass = new adminPassenger().passenger;
                JFrame frame = new JFrame("Passenger Ticket");
                frame.setContentPane(new adminPassenger().passenger);
                frame.pack();
                frame.setVisible(true);
            }
        });
        root.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pass = new adminRouteFlight().panel;
                JFrame frame = new JFrame("Update Route or Flight");
                frame.setContentPane(new adminRouteFlight().panel);
                frame.pack();
                frame.setVisible(true);

            }
        });

    }
}

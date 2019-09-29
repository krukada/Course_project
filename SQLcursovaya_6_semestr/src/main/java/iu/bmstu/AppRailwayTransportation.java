package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppRailwayTransportation {
    private JPanel rootPanel;
    private JButton person;
    private JButton admin;

    public AppRailwayTransportation()
    {
        person.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JPanel person = new Person().Person;
               JFrame frame = new JFrame("Person");
                frame.setContentPane(new Person().Person);
                frame.pack();
                frame.setVisible(true);
            }
        });
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel admin = new PasswordAdmin().pass;
                JFrame frame = new JFrame(" Password Admin");
                frame.setContentPane(new PasswordAdmin().pass);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Railway Transportation");
        frame.setContentPane(new AppRailwayTransportation().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

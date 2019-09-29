package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class adminRouteFlight {

    private JTextField text;
 JPanel panel;
    private JButton updateRout;
    private JButton updateFli;
    private JButton addFli;
    private JButton addRo;

    public adminRouteFlight(){
       updateRout.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JPanel pass = new UPDATERout().route;
               JFrame frame = new JFrame("Update route");
               frame.setContentPane(new UPDATERout().route);
               frame.pack();
               frame.setVisible(true);
           }
       });
       updateFli.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JPanel pass = new UPDATEFlight().flight;
               JFrame frame = new JFrame("Update flight");
               frame.setContentPane(new UPDATEFlight().flight);
               frame.pack();
               frame.setVisible(true);
           }
       });
        addFli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pass = new addFlight().flight;
                JFrame frame = new JFrame("Add flight");
                frame.setContentPane(new addFlight().flight);
                frame.pack();
                frame.setVisible(true);
            }
        });
        addRo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pass = new AddRoute().route;
                JFrame frame = new JFrame("Add route");
                frame.setContentPane(new AddRoute().route);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}

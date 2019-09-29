package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordAdmin {
    JPanel pass;
    private JTextField log;
    private JPasswordField password;
    public PasswordAdmin(){
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pas = "root";
                if (log.getText().equals(pas) && password.getText().equals(pas)){
                    JPanel admin = new Admin().Admin;
                    JFrame frame = new JFrame(" Admin");
                    frame.setContentPane(new  Admin().Admin);
                    frame.pack();
                    pass.setVisible(false);
                    frame.setVisible(true);
                }
            }
        });
    }
}

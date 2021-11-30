import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Frame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }

    public Frame() {
        super("LOGIN");
        setSize(450, 140);
        setLocation(510, 320);


        JToolBar toolBar = new JToolBar();



        getContentPane().add(toolBar,BorderLayout.PAGE_START);

        JButton item1 = new JButton("Login");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(item1,
                        "You are already on login page!");
            }
        });
        toolBar.add(item1);


        JButton item2 = new JButton("Password");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(item2,
                        "You are already on login page!");

            }
        });
        toolBar.add(item2);


        JButton submit = new JButton("SUBMIT");
        JButton clear = new JButton("CLEAR");

        JLabel userlab = new JLabel("Login");
        TextField userfield = new TextField(20);

        JLabel passlab = new JLabel("Password");
        JPasswordField passfield = new JPasswordField(20);


       JPanel panel1 = new JPanel(new GridLayout(3, 1));
        panel1.add(userlab);
        panel1.add(userfield);
        panel1.add(passlab);
        panel1.add(passfield);
        panel1.add(submit);
        panel1.add(clear);
        add(panel1, BorderLayout.CENTER);


        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userfield.setText("");
                passfield.setText("");
                panel1.setBackground(Color.LIGHT_GRAY);
                userfield.setBackground(Color.LIGHT_GRAY);
                passfield.setBackground(Color.LIGHT_GRAY);
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userVal = userfield.getText();
                char[] passVal = passfield.getPassword();

                String actualPas = new String(passVal);

                if(userVal.equals("login") && IsPasswordCorrect(passVal)==true)
                {
                    panel1.setBackground(Color.green);
                    userfield.setBackground(Color.green);
                    passfield.setBackground(Color.green);
                    JOptionPane.showMessageDialog(item2,
                            "Welcome!");
                }else {
                    panel1.setBackground(Color.red);
                    userfield.setBackground(Color.red);
                    passfield.setBackground(Color.red);
                    JOptionPane.showMessageDialog(item2,
                            "Wrong login or password!");
                }

            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public boolean IsPasswordCorrect(char[] tab) {
        String pass = "password";
        String passString = new String(tab);
           if (passString.equals(pass)) {
               return true;
    } else return false;
}
}





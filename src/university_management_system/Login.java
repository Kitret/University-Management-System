package university_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField tfUserName;
    private JPasswordField tfPassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(120, 60, 100, 20);
        add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(230,60,100,20);
        add(tfUserName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(120, 90, 100, 20);
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(230,90,100,20);
        add(tfPassword);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 140, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("Courier New", Font.BOLD, 16));
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 140, 100, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        cancelButton.setFont(new Font("Courier New", Font.BOLD, 16));
        add(cancelButton);

        ImageIcon academyIcon = new ImageIcon(ClassLoader.getSystemResource("icons/userIcon.png"));
        Image icon1 = academyIcon.getImage().getScaledInstance(150, 150, DO_NOTHING_ON_CLOSE);
        academyIcon=new ImageIcon(icon1);
        JLabel image = new JLabel(academyIcon);
        image.setBounds(400, 40, 150, 150);
        add(image);
        
        setVisible(true);
        setSize(600,300);
        setLocation(700, 300);
    }
    
    public static void main(String[] args) {
        new Login();
    }

    @Override
    @Deprecated
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==loginButton) {
            String userName=tfUserName.getText();
            String password=tfPassword.getText();

            String query = "select * from userInitials where user_name='"+userName+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet res = c.s.executeQuery(query);

                if(res.next()) {
                    setVisible(false);
                    new Project();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource()==cancelButton) {
            setVisible(false);
        }
    }
}

package university_management_system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;

public class Splash extends JFrame implements Runnable{

    Thread t;

    Splash() {
        
        ImageIcon academyIcon = new ImageIcon(ClassLoader.getSystemResource("icons/academy_building.jpg"));
        Image icon1 = academyIcon.getImage().getScaledInstance(1100, 700, DO_NOTHING_ON_CLOSE);
        academyIcon=new ImageIcon(icon1);
        JLabel image = new JLabel(academyIcon);
        add(image);
        
        t=new Thread(this);
        t.start();

        setLocation(500, 200);
        for(int i=100;i<=700;i+=6) {
            setSize(3*(i/2), i);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);

            // showing next frame
            new Login();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

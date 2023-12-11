package university_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Project extends JFrame implements ActionListener{
    
    Project() {

        ImageIcon academyIcon = new ImageIcon(ClassLoader.getSystemResource("icons/academy_building.jpg"));
        Image icon1 = academyIcon.getImage().getScaledInstance(1920, 1000, DO_NOTHING_ON_CLOSE);
        academyIcon=new ImageIcon(icon1);
        JLabel image = new JLabel(academyIcon);
        add(image);

// Top Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);

    // Menu Item for Adding New Information 
        JMenu newInfo = new JMenu("New Information");
        newInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(newInfo);

        JMenuItem newFacultyInfo = new JMenuItem("New Faculty Information");
        newFacultyInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
        newInfo.add(newFacultyInfo);

        JMenuItem newStudentInfo = new JMenuItem("New Student Information");
        newStudentInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
        newInfo.add(newStudentInfo);


    // Menu Item for Viewing Details
        JMenu viewDetails = new JMenu("View Details");
        viewDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(viewDetails);

        JMenuItem viewFacultyDetails = new JMenuItem("View Faculty Details");
        viewFacultyDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        viewDetails.add(viewFacultyDetails);

        JMenuItem viewStudentDetails = new JMenuItem("View Student Details");
        viewStudentDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        viewDetails.add(viewStudentDetails);

    // Menu Item for Applying for leave
        JMenu applyLeave = new JMenu("Apply Leave");
        applyLeave.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(applyLeave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setFont(new Font("Monospaced", Font.BOLD, 16));
        applyLeave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setFont(new Font("Monospaced", Font.BOLD, 16));
        applyLeave.add(studentLeave);

    // Menu Item to view leave details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        leaveDetails.add(studentLeaveDetails);

    // Menu Item to view Examination Details
        JMenu exam = new JMenu("Examination");
        exam.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(exam);

        JMenuItem examResults = new JMenuItem("Examination Results");
        examResults.setFont(new Font("Monospaced", Font.BOLD, 16));
        exam.add(examResults);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setFont(new Font("Monospaced", Font.BOLD, 16));
        exam.add(enterMarks);

    // Menu Item to update Information
        JMenu updateInfo = new JMenu("Update Information");
        updateInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(updateInfo);

        JMenuItem updateFacultyDetails = new JMenuItem("Update Faculty Details");
        updateFacultyDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        updateInfo.add(updateFacultyDetails);

        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        updateInfo.add(updateStudentDetails);

    // Menu Item to Fee Details
        JMenu feeDetails = new JMenu("Fee Details");
        feeDetails.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(feeDetails);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setFont(new Font("Monospaced", Font.BOLD, 16));
        feeDetails.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setFont(new Font("Monospaced", Font.BOLD, 16));
        feeDetails.add(feeForm);

    // Menu Item to Utilities
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("Monospaced", Font.BOLD, 16));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("Monospaced", Font.BOLD, 16));
        calculator.addActionListener(this);
        utility.add(calculator);

    // Menu Item to Logout of Application
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Monospaced", Font.BOLD, 16));
        menuBar.add(exit);
        JMenuItem logout = new JMenuItem("Logout");
        logout.setFont(new Font("Monospaced", Font.BOLD, 16));
        logout.addActionListener(this);
        exit.add(logout);


        setJMenuBar(menuBar);

        setSize(1920,1080);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    @Deprecated
    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();

        if(cmd.equals("Logout")) {
            setVisible(false);
        }
        else if(cmd.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        else if(cmd.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }    
        }
    }
}

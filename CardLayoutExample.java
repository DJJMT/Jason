import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CardLayoutExample
{
    private JPanel contentPane;
    private MyPanel panel1;
    private MyPanel2 panel2;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Team J Calendar Application");
//        frame.setBounds(550,100,350,200);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panel1 = new MyPanel(contentPane);
        panel2 = new MyPanel2();
        contentPane.add(panel1, "Panel 1");
        contentPane.add(panel2, "Panel 2");
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setBounds(550,100,350,200);
        frame.setResizable(false);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CardLayoutExample().displayGUI();
            }
        });
    }
}

class MyPanel extends JPanel {

    private JTextField Username_Box;
    private JPasswordField Password_Box;
    private JLabel Username_Label;
    private JLabel Password_Label;
    private JLabel Title;
    private JButton Create_Button;
    private JButton Login_Button;
    private JPanel contentPane;

    public MyPanel(JPanel panel) {

        contentPane = panel;

        //construct components
        Username_Box = new JTextField();
        Password_Box = new JPasswordField();
        Username_Label = new JLabel ("USERNAME:");
        Password_Label = new JLabel ("PASSWORD:");
        Create_Button = new JButton ("New User? Click Here");
        Login_Button = new JButton ("LOGIN");

        //adjust size and set layout
//        setPreferredSize (new Dimension (350, 200));
//        setLayout (null);
        setBounds(550,100,350,200);
        

        //set component bounds (only needed by Absolute Positioning)
//        Username.setBounds (245, 50, 60, 25);
		Username_Label.setLayout(null);
		Username_Label.setLocation(10, 60);
		Username_Label.setSize(80,25);
		Username_Label.setForeground(Color.white);
		add(Username_Label);

		Password_Label.setLayout(null);
		Password_Label.setLocation(100, 10);
		Password_Label.setSize(80,25);
		Password_Label.setForeground(Color.white);
		
	    Username_Box.setLayout(null);
	    Username_Box.setLocation(120, 60);
	    Username_Box.setSize(210, 25);
	    Username_Box.setBackground(Color.BLACK);
		Username_Box.setForeground(Color.white);
		
	    Password_Box.setLayout(null);
	    Password_Box.setLocation(120, 100);
	    Password_Box.setSize(210, 25);
	    Password_Box.setBackground(Color.BLACK);
		Password_Box.setForeground(Color.white);
		
	    Create_Button.setLayout(null);
	    Create_Button.setLocation(00, 140);
	    Create_Button.setSize(165, 25);
	    Create_Button.setFocusPainted(false);
	    Create_Button.setMargin(new Insets(0,0,0,0));
	    Create_Button.setContentAreaFilled(false);
	    Create_Button.setBorderPainted(false);
	    Create_Button.setOpaque(false);
	    Create_Button.setForeground(Color.BLACK);
	    Create_Button.setFont(new Font("Arial", Font.ITALIC, 16));
//	    ClickListener cl = new ClickListener();
//		Create_Button.addActionListener(cl);
		
	    Login_Button.setLayout(null);
	    Login_Button.setLocation(185, 140);
	    Login_Button.setSize(125, 25);

	    Login_Button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });

        //add components
        add (Username_Label);
        add (Username_Box);
        add (Password_Label);
        add (Password_Box);
        add (Login_Button);
        add (Create_Button);
    }
}

class MyPanel2 extends JPanel {
    private JButton jcomp1;
    private JButton Username_Label;
    private JButton Password_Label;
    private JTextField Login_Button;

    public MyPanel2() {
        //construct components
        jcomp1 = new JButton ("test1");
        Username_Label = new JButton ("test2");
        Password_Label = new JButton ("test3");
        Login_Button = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (20, 45, 100, 25);
        Username_Label.setBounds (135, 60, 100, 25);
        Password_Label.setBounds (260, 35, 100, 25);
        Login_Button.setBounds (105, 115, 100, 25);

        //add components
        add (jcomp1);
        add (Username_Label);
        add (Password_Label);
        add (Login_Button);       
    }
}

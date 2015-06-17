/**
 * Created by Henry Nichols on 4/16/15.
 */

import javax.swing.*;			// for GUI
import java.awt.*;				// for GUI
import java.awt.color.*;		// for Color
import java.awt.event.*;		// for events
import java.io.*;				   // for files
import java.util.*;			   // for date
import java.text.*;			  // number format
import javax.swing.border.*;	// to change an item's border
import javax.swing.JOptionPane; // to use JOptionPane in the try/catch block
import java.text.*;

public class Q2L04 extends JFrame implements ActionListener {
    JButton q2l; // global - program knows this exists declare and instantiate in the constructor
    JButton l2q;
    JButton exit;

    JTextField inQuarts;
    JTextField outLiters;

    public Q2L04()
    {
        setTitle("JButton Demo");
        setSize(267, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = 267;
        int height = 400;
        setLocation((d.width - width)/2, (d.height - height)/2);

        // Create buttons and add Listeners
        q2l = new JButton("Q2L");
        l2q = new JButton("L2Q");
        exit = new JButton("Exit");

        // Register buttons
        q2l.addActionListener(this);
        l2q.addActionListener(this);
        exit.addActionListener(this);

        // Create two text fields
        inQuarts = new JTextField(7);
        outLiters = new JTextField(7);

        // Create two panels to hold the separate text fields
        JPanel textFieldNorth = new JPanel();
        JPanel textFieldSouth = new JPanel();

        // Center the text fields within each panel using default FlowLayout
        textFieldNorth.setLayout(new FlowLayout());
        textFieldSouth.setLayout(new FlowLayout());

        // Set the background color for each panel (to align with background color of container below)
        textFieldNorth.setBackground(Color.yellow);
        textFieldSouth.setBackground(Color.yellow);

        // Add each text field to its proper container
        textFieldNorth.add(inQuarts);
        textFieldSouth.add(outLiters);

        // Create a panel to hold the input buttons
        JPanel buttonsWest = new JPanel();

        // Stack the input buttons on top of each other within a Grid Layout
        buttonsWest.setLayout(new GridLayout(2,0));

        // Set background color for panel (to align with background color of container below)
        buttonsWest.setBackground(Color.yellow);

        // Add each input button to its proper container
        buttonsWest.add(q2l);
        buttonsWest.add(l2q);

        // Create content container and add panels
        Container content = getContentPane();
        content.setBackground(Color.yellow);

        content.setLayout(new BorderLayout());

        content.add(textFieldNorth, BorderLayout.NORTH);
        content.add(textFieldSouth, BorderLayout.SOUTH);
        content.add(buttonsWest, BorderLayout.WEST);
        content.add(exit, BorderLayout.EAST);

    } // End Constructor

    public void actionPerformed(ActionEvent ae)
    {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(4);
        df.setMaximumFractionDigits(4);

        Object source = ae.getSource();
        double calcQt, calcLtr;
        String inString;

        try {
            if (source == exit) System.exit(0);
            else if (source == q2l) {
                inString = inQuarts.getText();
                if(inString.isEmpty()) {
                    JOptionPane.showMessageDialog
                            (null, "no input data was entered", "alert", JOptionPane.ERROR_MESSAGE);
                } else {
                    calcQt = Double.parseDouble(inString);
                    calcLtr = calcQt * 0.9463529;
                    outLiters.setText(df.format(calcLtr));
                    System.out.println(inString);
                }
            } else if (source == l2q) {
                inString = inQuarts.getText();
                if(inString.isEmpty()) {
                    JOptionPane.showMessageDialog
                            (null, "no input data was entered", "alert", JOptionPane.ERROR_MESSAGE);
                } else {
                    calcLtr = Double.parseDouble(inString);
                    calcQt = calcLtr * 1.0566882;
                    outLiters.setText(df.format(calcQt));
                    System.out.println(inString);
                }
            }
        } catch(NumberFormatException exc) {
            JOptionPane.showMessageDialog
                    (null, "entered an invalid number - " + exc.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
        }
    } // End ActionPerformed

    public static void main(String args[])
    {
        Q2L04 fl = new Q2L04();
        fl.setVisible(true);
    }
}

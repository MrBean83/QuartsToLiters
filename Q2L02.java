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

public class Q2L02 extends JFrame implements ActionListener {
        JButton q2l; // global - program knows this exists declare and instantiate in the constructor
        JButton exit;

        JTextField inQuarts;
        JTextField outLiters;

        public Q2L02()
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
            exit = new JButton("Exit");

            // Register buttons
            q2l.addActionListener(this);
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

            // Create content container and add panels
            Container content = getContentPane();
            content.setBackground(Color.yellow);

            content.setLayout(new BorderLayout());

            content.add(textFieldNorth, BorderLayout.NORTH);
            content.add(textFieldSouth, BorderLayout.SOUTH);
            content.add(q2l, BorderLayout.WEST);
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

            if(source == exit) System.exit(0);
            else
            {
                inString = inQuarts.getText();
                calcQt = Double.parseDouble(inString);
                calcLtr = calcQt * 0.9463529;
                outLiters.setText(df.format(calcLtr));
                System.out.println(inString);
            }
        } // End ActionPerformed

        public static void main(String args[])
        {
            Q2L02 fl = new Q2L02();
            fl.setVisible(true);
        }
}

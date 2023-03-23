package asset;

import javax.swing.*;
import java.awt.*;

public class TEST2 extends JFrame {

    public TEST2() {
        // Set up the JFrame
        setTitle("Game Layout");
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a top-level panel to hold the three main components
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a panel for the score on the left
        JPanel scorePanel = new JPanel();
        scorePanel.add(new JLabel("Score: 0"));
        mainPanel.add(scorePanel, BorderLayout.WEST);

        // Create a panel for the time in the center
        JPanel timePanel = new JPanel();
        timePanel.add(new JLabel("Time: 0"));
        mainPanel.add(timePanel, BorderLayout.CENTER);

        // Create a panel for the life on the right
        JPanel lifePanel = new JPanel();
        lifePanel.add(new JLabel("Life: 100%"));
        mainPanel.add(lifePanel, BorderLayout.EAST);

        // Create a panel for the three buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        TEST2 gameLayout = new TEST2();
    }
}


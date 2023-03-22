package asset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame implements ActionListener {
    
    private JButton playButton, multiplayerButton, exitButton;

    public Test() {
        setTitle("Menu Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Create a JPanel with BoxLayout and center alignment
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        // Create the buttons
        playButton = new JButton("Play");
        multiplayerButton = new JButton("Multiplayer");
        exitButton = new JButton("Exit");

        // Add the buttons to the panel
        panel.add(playButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(multiplayerButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exitButton);

        // Add the panel to the frame
        add(panel);
        
        // Add action listeners to the buttons
        playButton.addActionListener(this);
        multiplayerButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            // Code to start the game goes here
            System.out.println("Starting game...");
        } else if (e.getSource() == multiplayerButton) {
            // Code to start the multiplayer mode goes here
            System.out.println("Starting multiplayer...");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Test menu = new Test();
        menu.setVisible(true);
    }
}

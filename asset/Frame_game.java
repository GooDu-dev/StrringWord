package asset;

import javax.swing.*;
import java.awt.*;

public class Frame_game extends JFrame {
    private JButton play, multiplayer, exit,back, mainMenuButton;
    private JPanel mainMenuPanel, scorePanel, wordPanel, textPanel, typeTextPanel;
    private JLabel singlePlayerScore, p1Score, p2Score, timeLabel, lifeLabel;
    private JTextField typeTextField;
    
    public Frame_game(){
        DEFAULT();
    }
    public Frame_game(String name) {
        this.setTitle(name);
        DEFAULT();
    }
    public void DEFAULT(){
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        // Icon Game
        ImageIcon icon = new ImageIcon("");
        this.setIconImage(icon.getImage());
        // Set Background
        this.getContentPane().setBackground(Color.BLACK);

        mainMenu();
        // singleMainGame();
        // multiplayerMainGame();
        // gameOverMenu();
        this.setVisible(true);
    }


    public void mainMenu() {
        // Create a JPanel with BoxLayout and center alignment
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.YELLOW);
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    
        // create PLAY button
        play = new JButton("PLAY");
        play.addActionListener(e -> {
            ConnectIP();
        });
        // create MULTIPLAYER button
        multiplayer = new JButton("MULTIPLAYER");
        multiplayer.addActionListener(e -> {
            // add action multiplayer
        });
        // create EXIT button
        exit = new JButton("EXIT");
        exit.addActionListener(e -> System.exit(0));
    
        // Add the buttons to the mainMenuPanel
        mainMenuPanel.add(Box.createVerticalGlue()); // push buttons towards center vertically
        mainMenuPanel.add(play);
        mainMenuPanel.add(Box.createVerticalStrut(20)); //space
        mainMenuPanel.add(multiplayer);
        mainMenuPanel.add(Box.createVerticalStrut(20)); //space
        mainMenuPanel.add(exit);
        mainMenuPanel.add(Box.createVerticalGlue()); // push buttons towards center vertically
    
        // set button to center
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        multiplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Add the panel to the frame
        // this.add(mainMenuPanel, BorderLayout.CENTER);
        getContentPane().add(mainMenuPanel, BorderLayout.CENTER);
    }
    
    public void clearScreen() {
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void ConnectIP(){
        clearScreen(); 

        // set back button to bottom
        this.setLayout(null);
        back = new JButton("Back");
        back.setBounds(new Rectangle(100, 450, 200, 65));
        getContentPane().add(back);
        back.addActionListener(e -> {
            clearScreen();
            // mainMenu();
            System.out.println("Debug connect ip here !");

            getContentPane().setBackground(Color.red);
            mainMenu();
            revalidate();
            repaint();
        });
    }

    public void singleMainGame(){
        setLayout(new BorderLayout());
        scorePanel = new JPanel();
        wordPanel = new JPanel();
        textPanel = new JPanel();

        scorePanel.setBackground(Color.orange);
        wordPanel.setBackground(Color.cyan);
        textPanel.setBackground(Color.green);

        scorePanel.setLayout(new BorderLayout());
        // scorePanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.X_AXIS));
        singlePlayerScore = new JLabel("Score single");
        timeLabel = new JLabel("timeLabel 60", SwingConstants.CENTER);
        lifeLabel = new JLabel("LIFE");

        singlePlayerScore.setForeground(Color.magenta);
        timeLabel.setForeground(Color.blue);
        lifeLabel.setForeground(Color.magenta);

        // timeLabel.setHorizontalTextPosition(JLabel.CENTER);

        scorePanel.add(singlePlayerScore, BorderLayout.WEST);
        scorePanel.add(timeLabel, BorderLayout.CENTER);
        scorePanel.add(lifeLabel, BorderLayout.EAST);
        scorePanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.1f)));


        // todo : add logic label here
        JLabel randomWord = new JLabel("RAndom Multiplayer");
        wordPanel.add(randomWord);

        typeTextField = new JTextField("lorem lorem lorem ................ lorem lorem lorem");
        // textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.3f)));
        typeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.3f)));
        textPanel.add(typeTextField);

        getContentPane().add(scorePanel, BorderLayout.NORTH);
        getContentPane().add(wordPanel, BorderLayout.CENTER);
        getContentPane().add(textPanel, BorderLayout.SOUTH);
    }
    
    public void multiplayerMainGame(){
        setLayout(new BorderLayout());
        scorePanel = new JPanel();
        wordPanel = new JPanel();
        textPanel = new JPanel();

        scorePanel.setBackground(Color.orange);
        wordPanel.setBackground(Color.cyan);
        textPanel.setBackground(Color.green);

        scorePanel.setLayout(new BorderLayout());
        // scorePanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.X_AXIS));
        p1Score = new JLabel("P1 Score");
        timeLabel = new JLabel("timeLabel 60", SwingConstants.CENTER);
        p2Score = new JLabel("P2 Score");

        p1Score.setForeground(Color.magenta);
        timeLabel.setForeground(Color.blue);
        p2Score.setForeground(Color.magenta);

        // timeLabel.setHorizontalTextPosition(JLabel.CENTER);

        scorePanel.add(p1Score, BorderLayout.WEST);
        scorePanel.add(timeLabel, BorderLayout.CENTER);
        scorePanel.add(p2Score, BorderLayout.EAST);
        scorePanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.1f)));


        // todo : add logic label here
        JLabel randomWord = new JLabel("Random word dummy dummy dummy");
        wordPanel.add(randomWord);

        typeTextField = new JTextField("lorem lorem lorem ................ lorem lorem lorem");
        // textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.3f)));
        typeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.3f)));
        textPanel.add(typeTextField);

        getContentPane().add(scorePanel, BorderLayout.NORTH);
        getContentPane().add(wordPanel, BorderLayout.CENTER);
        getContentPane().add(textPanel, BorderLayout.SOUTH);
    }

    public void gameOverMenu(){
        clearScreen(); 

        this.setLayout(null);
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(new Rectangle(100, 450, 200, 65));
        getContentPane().add(mainMenuButton);
        mainMenuButton.addActionListener(e -> {
            clearScreen();
            mainMenu();
        });
    }
    
    public void timeUpMenu(){
        clearScreen(); 

        this.setLayout(null);
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(new Rectangle(100, 450, 200, 65));
        getContentPane().add(mainMenuButton);
        mainMenuButton.addActionListener(e -> {
            clearScreen();
            mainMenu();
        });
    }
}

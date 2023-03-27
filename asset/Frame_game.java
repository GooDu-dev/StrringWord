package asset;

import javax.swing.*;
import asset.scripts.Counting;
import asset.scripts.Data;
import asset.scripts.Word;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame_game extends JFrame {
    private JButton gameName, play, easy, medium, hard, exit,back, mainMenuButton;
    private JPanel mainMenuPanel, selecLevel, scorePanel, wordPanel, textPanel,score,time,Life;
    private JTextField typeTextField;
    private JLabel word,title;
    private int level=Data.EASY;
    
    private Counting main_counting;
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
        ImageIcon icon = new ImageIcon("asset/picture/background/content.png");
        this.setIconImage(icon.getImage());
        // Set Background
        this.getContentPane().setBackground(Color.BLACK);
        mainMenu();
        // singleMainGame();
         //gameOverMenu();
        // timeUpMenu();
        this.setVisible(true);
    }

    public void mainMenu() {
        clearScreen();
        // Create a JPanel with BoxLayout and center alignment
        //backgroundImageJFrame("asset/picture/background/Artboard-1.png");
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(new Color(231,197,79,255));
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        gameName = new JButton("String WORD;");
        gameName.setFont(new Font("Aria", Font.BOLD, 35));
        gameName.setOpaque(false);
        gameName.setContentAreaFilled(false);
        gameName.setBorderPainted(false);
        // create PLAY button
        play = new JButton(new ImageIcon("asset/picture/button/play-button.png"));
        play.addActionListener(e -> {
            selectLevel();
        });
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        // create EXIT button
        exit = new JButton(new ImageIcon("asset/picture/button/exit-button.png"));
        exit.addActionListener(e -> System.exit(0));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
    
        // Add the buttons to the mainMenuPanel
        mainMenuPanel.add(Box.createVerticalGlue()); // push buttons towards center vertically
        mainMenuPanel.add(gameName);
        mainMenuPanel.add(Box.createVerticalStrut(20)); //space
        mainMenuPanel.add(play);
        mainMenuPanel.add(Box.createVerticalStrut(20)); //space
        mainMenuPanel.add(exit);
        mainMenuPanel.add(Box.createVerticalGlue()); // push buttons towards center vertically
    
        // set button to center
        gameName.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Add the panel to the frame
        getContentPane().add(mainMenuPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void selectLevel() {
        // Create a JPanel with BoxLayout and center alignment
        clearScreen();
        selecLevel = new JPanel();
        selecLevel.setBackground(new Color(231,197,79,255));
        selecLevel.setLayout(new BoxLayout(selecLevel, BoxLayout.Y_AXIS));
        selecLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        selecLevel.setAlignmentY(Component.CENTER_ALIGNMENT);
    
        // create east button
        easy = new JButton(new ImageIcon("asset/picture/button/easy-button.png"));
        easy.addActionListener(e -> {
            level = Data.EASY;
            singleMainGame();
        });
        easy.setOpaque(false);
        easy.setContentAreaFilled(false);
        easy.setBorderPainted(false);
        // create medium button
        medium = new JButton(new ImageIcon("asset/picture/button/medium-button.png"));
        medium.addActionListener(e -> {
            level = Data.MEDIUM;
            singleMainGame();
        });
        medium.setOpaque(false);
        medium.setContentAreaFilled(false);
        medium.setBorderPainted(false);
        // create hard button
        hard = new JButton(new ImageIcon("asset/picture/button/hard-button.png"));
        hard.addActionListener(e -> {
            level = Data.HARD;
            singleMainGame();
        });
        hard.setOpaque(false);
        hard.setContentAreaFilled(false);
        hard.setBorderPainted(false);
    
        // Add the buttons to the mainMenuPanel
        selecLevel.add(Box.createVerticalGlue()); // push buttons towards center vertically
        selecLevel.add(easy);
        selecLevel.add(Box.createVerticalStrut(20)); //space
        selecLevel.add(medium);
        selecLevel.add(Box.createVerticalStrut(20)); //space
        selecLevel.add(hard);
        selecLevel.add(Box.createVerticalGlue()); // push buttons towards center vertically
    
        // set button to center
        easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        medium.setAlignmentX(Component.CENTER_ALIGNMENT);
        hard.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Add the panel to the frame
        getContentPane().add(selecLevel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    
    public void clearScreen() {
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void singleMainGame(){
        clearScreen();

        // create panel and set Layout Outer
        scorePanel = new JPanel();
        wordPanel = new JPanel();
        textPanel = new JPanel();

        // panel of scorePanel Inner
        score = new JPanel();
        time = new JPanel();
        Life = new JPanel();

        // use for check area panel Can Delete If you want
        scorePanel.setBackground(Color.DARK_GRAY);
        wordPanel.setBackground(Color.DARK_GRAY);
        textPanel.setBackground(Color.DARK_GRAY);

        word = new JLabel(Word.word);
        word.setFont(new Font("Verdana",Font.BOLD ,25));
        word.setForeground(Color.WHITE);
        wordPanel.setLayout(new BorderLayout());
        word.setHorizontalAlignment(JLabel.CENTER);
        word.setVerticalAlignment(JLabel.CENTER);
        wordPanel.add(word,BorderLayout.CENTER);


        JLabel time_number = new JLabel("Time : "+level);
        JLabel life_Label = new JLabel("Life : "+Data.life);
        JLabel scorLabel = new JLabel("Score : "+ Data.score);

        time_number.setForeground(Color.WHITE);
        life_Label.setForeground(Color.WHITE);
        scorLabel.setForeground(Color.WHITE);

        main_counting = new Counting(level, time_number, life_Label, this);
        main_counting.start();
        score.add(scorLabel).setFont(new Font("Verdana",Font.BOLD ,14));
        score.setOpaque(false);
        time.add(time_number).setFont(new Font("Verdana",Font.BOLD ,14 ));
        time.setOpaque(false);
        Life.add(life_Label).setFont(new Font("Verdana",Font.BOLD ,14 ));
        Life.setOpaque(false);

        scorePanel.add(score,BorderLayout.WEST);
        scorePanel.add(time,BorderLayout.CENTER);
        scorePanel.add(Life,BorderLayout.EAST);

        // set text field 
        typeTextField = new JTextField(20);
        typeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        typeTextField.setFont(new Font("Arial",Font.BOLD ,18 ));
        typeTextField.setPreferredSize(new Dimension(150, 50));
        textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.15f)));
        textPanel.add(typeTextField);
        typeTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TextField : "+typeTextField.getText());
                System.out.println("Word.word : "+Word.word);
                System.out.println(typeTextField.getText().equals(Word.word));
                if(typeTextField.getText().toLowerCase().equals(Word.word.toLowerCase())){
                    Word.word = Word.getRandomWord();
                    word.setText(Word.word);
                    main_counting.setN(level);
                    scorLabel.setText("Score : "+(++Data.score));
                }
                else{
                    main_counting.interrupt();
                }
                typeTextField.setText("");
            }
        });

        // add each panel to frame
        this.getContentPane().add(scorePanel, BorderLayout.NORTH);
        this.getContentPane().add(wordPanel, BorderLayout.CENTER);
        this.getContentPane().add(textPanel, BorderLayout.SOUTH);   
    }

    public void gameOverMenu(){
        clearScreen();
        Data.life = 3;
        Data.score = 0;

        JLabel gameOverText = new JLabel("GAME OVER");
        gameOverText.setForeground(Color.RED);
        gameOverText.setBounds(100, 100, 200, 50); // set the position and size of the label
        gameOverText.setFont(new Font("Impact", Font.BOLD, 30));
        gameOverText.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOverText.setAlignmentY(Component.CENTER_ALIGNMENT);
        getContentPane().add(gameOverText);

        mainMenuButton = new JButton(new ImageIcon("asset/picture/button/main-button.png"));
        mainMenuButton.setBounds(new Rectangle(100, 450, 200, 65));
        mainMenuButton.setOpaque(false);
        mainMenuButton.setContentAreaFilled(false);
        mainMenuButton.setBorderPainted(false);
        getContentPane().add(mainMenuButton);
        
        mainMenuButton.addActionListener(e -> {
            clearScreen();
            mainMenu();
        });
    }

    public void hurt(JLabel time_number, JLabel life_text){
        Data.life--;
        if(Data.life <= 0){
            if(Data.score >= Data.getHighestScore()){
                Data.setHighestScore(Data.score);
            }
            gameOverMenu();
        }
        time_number.setText("Time : "+level);
        main_counting = new Counting(level, time_number, life_text, this);
        main_counting.start();
        life_text.setText("Life : "+Data.life);
    }
}

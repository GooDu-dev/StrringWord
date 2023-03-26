package asset;

import javax.print.attribute.standard.Severity;
import javax.swing.*;

import asset.scripts.Server;
import asset.scripts.User;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Frame_game extends JFrame {
    private JButton play, multiplayer, exit,back, mainMenuButton;
    private JPanel mainMenuPanel, scorePanel,scorePanelMulti, wordPanel, textPanel,score,time,Life,score_p1,score_p2;
    private JTextField typeTextField;

    // Server & Clients
    private ServerSocket serverSocket;
    private Server server;
    private Thread server_thread;
    
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
<<<<<<< refs/remotes/origin/main

        mainMenu();
        // singleMainGame();
        // multiplayerMainGame();
        // gameOverMenu();

=======
        mainMenu();
>>>>>>> UPDATE GUI
        this.setVisible(true);
    }


    public void mainMenu() {
        clearScreen();
        // Create a JPanel with BoxLayout and center alignment
        clearScreen();
        backgroundImageJFrame();
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(new Color(255, 255, 255, 128));
        mainMenuPanel.setOpaque(false);
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    
        // create PLAY button
        play = new JButton(new ImageIcon("asset/picture/button/play-button.png"));
        play.addActionListener(e -> {
            singleMainGame();
        });
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        // create MULTIPLAYER button
        multiplayer = new JButton(new ImageIcon("asset/picture/button/multiplayer-button.png"));
        multiplayer.addActionListener(e -> {
            ConnectIP();
        });
        multiplayer.setOpaque(false);
        multiplayer.setContentAreaFilled(false);
        multiplayer.setBorderPainted(false);
        // create EXIT button
        exit = new JButton(new ImageIcon("asset/picture/button/exit-button.png"));
        exit.addActionListener(e -> System.exit(0));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
    
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
        getContentPane().add(mainMenuPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    
    public void clearScreen() {
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void ConnectIP(){
        clearScreen(); 

        // 
        // String ip = Server.generateIP();
        // if(ip != null){
        //     if(server == null){
        //         try{
        //             serverSocket = new ServerSocket(1234);
        //             Server server = new Server(serverSocket);
        //             server_thread = new Thread(new Runnable(){
        //                 @Override
        //                 public void run() {
        //                     while(!serverSocket.isClosed()){
        //                         server.start();
        //                     }
        //                 }
        //             });
        //             server_thread.start();
        //         }
        //         catch(IOException e){
        //             System.out.println(e);
        //             clearServer();
        //         }
        //     }
        // }


        // set back button to bottom
        this.setLayout(null);
<<<<<<< refs/remotes/origin/main
        back = new JButton(new ImageIcon("asset/picture/button/back-button.png"));
        back.setBounds(new Rectangle(100, 450, 200, 65));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        getContentPane().add(back);
        back.addActionListener(e -> {
            // clearScreen();
            // mainMenu();
=======
        back = new JButton("Back");
        back.setBounds(new Rectangle(120, 500, 150, 30));
        getContentPane().add(back);
        back.addActionListener(e -> {
>>>>>>> UPDATE GUI
            System.out.println("Debug connect ip here !");
            mainMenu();
        });
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

        // use for cheack area panel Can Delete If you want
        scorePanel.setBackground(Color.orange);
        wordPanel.setBackground(Color.cyan);
        textPanel.setBackground(Color.green);

        // scorePanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.05f)));
        score.add(new JLabel("Score : 0"));
        time.add(new JLabel("Time : 0"));
        Life.add(new JLabel("Life : 100%"));

        scorePanel.add(score,BorderLayout.WEST);
        scorePanel.add(time,BorderLayout.CENTER);
        scorePanel.add(Life,BorderLayout.EAST);

        // todo : add logic label here

        // set text field 
        typeTextField = new JTextField(20);
        typeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.1f)));
        textPanel.add(typeTextField);

        // add each panel to frame
        this.getContentPane().add(scorePanel, BorderLayout.NORTH);
        this.getContentPane().add(wordPanel, BorderLayout.CENTER);
        this.getContentPane().add(textPanel, BorderLayout.SOUTH);
    }
    
    public void multiplayerMainGame(){
        clearScreen();
        // create panel and set Layout Outer
        setLayout(new BorderLayout());
        scorePanelMulti = new JPanel();
        wordPanel = new JPanel();
        textPanel = new JPanel();

        // panel of scorePanelMulti Inner
        score_p1 = new JPanel();
        score_p2 = new JPanel();
        time = new JPanel();

        // use for cheack area panel Can Delete If you want
        scorePanelMulti.setBackground(Color.orange);
        wordPanel.setBackground(Color.cyan);
        textPanel.setBackground(Color.green);

        // scorePanelMulti.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.05f)));
        score_p1.add(new JLabel("Score P1 : 0"));
        score_p2.add(new JLabel("Score P2 : 0"));
        time.add(new JLabel("Time : 0"));

        scorePanelMulti.add(score_p1,BorderLayout.WEST);
        scorePanelMulti.add(time,BorderLayout.CENTER);
        scorePanelMulti.add(score_p2,BorderLayout.EAST);

        scorePanelMulti.add(score_p1, BorderLayout.WEST);
        scorePanelMulti.add(time, BorderLayout.CENTER);
        scorePanelMulti.add(score_p2, BorderLayout.EAST);
        scorePanelMulti.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.05f)));

        // todo : add logic label here
        JLabel randomWord = new JLabel();
        wordPanel.add(randomWord);

        typeTextField = new JTextField(20);
        typeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        textPanel.setPreferredSize(new Dimension(getWidth(), (int)(getHeight() * 0.1f)));
        textPanel.add(typeTextField);

        getContentPane().add(scorePanelMulti, BorderLayout.NORTH);
        getContentPane().add(wordPanel, BorderLayout.CENTER);
        getContentPane().add(textPanel, BorderLayout.SOUTH);
    }

    public void gameOverMenu(){
        clearScreen(); 

        this.setLayout(null);
        mainMenuButton = new JButton(new ImageIcon("asset/picture/button/mainmenu-button.png"));
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 24));
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
    
    public void timeUpMenu(){
        clearScreen(); 

        this.setLayout(null);
        mainMenuButton = new JButton(new ImageIcon("asset/picture/button/mainmenu-button.png"));
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

    public void backgroundImageJFrame(){
        setContentPane(new JLabel(new ImageIcon("asset/picture/background/Artboard-1.png")));
        setLayout(new FlowLayout());
        setSize(getWidth(), getHeight());
	}
    public void clearServer(){
        try{
            if(server != null) server.stop();   
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

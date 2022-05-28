import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class RunGame extends Thread {
    int duckHpMultilplyer = 1;
    JFrame game;
    int startDifflvl;
    int difflvl;
    ExitShortcut listener;
    JTextField hpField;
    JTextField PointsField;
    JButton tree1;
    JButton tree2;
    JTextField timeField;
    JTextField weaponField;
    JFrame main;
    TimeCounter timeCounter;
    JLayeredPane layeredPane;

    JFrame userName;
    JTextField userNameField;
    JButton confirmName;

    RunGame(int difficulty, JFrame main) {
       this.main = main;
        difflvl = difficulty;
        startDifflvl = difficulty==1?difflvl:difflvl==3?2:3;

        game = new JFrame("Hunt them Down!");
        PointsField = new JTextField("0");
        PointsField.setPreferredSize(new Dimension(20,20));
        timeField = new JTextField("0");

        weaponField = new JTextField(String.valueOf(new GetFromFile().getDmg()));

        hpField = new JTextField("100");
        hpField.setPreferredSize(new Dimension(30,20));
        JPanel pointPanel = new JPanel();
        JPanel timePanel = new JPanel();
        JPanel hpPanel = new JPanel();
        JPanel weaponPanel = new JPanel();



        // implementing shortcut
        JTextField textField = new JTextField();
        listener = new ExitShortcut(this);
        textField.addKeyListener(listener);
        game.add(textField);

        game.setMinimumSize(new Dimension(1500, 1000));
        timePanel.add(new JLabel("Time:"));
        timePanel.add(timeField);
        timePanel.setBounds(game.getWidth() - 200, 0, 100, 30);
        timePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        hpPanel.add(new JLabel("Hp left:"));
        hpPanel.add(hpField);
        hpPanel.setBounds(game.getWidth() / 2-50, 0, 100, 30);
        hpPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        pointPanel.add(new JLabel("Score:"));
        pointPanel.add(PointsField);
        pointPanel.setBounds(50, 0, 100, 30);
        pointPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        weaponPanel.add(new JLabel("LvL of weapon:"));
        weaponPanel.add(weaponField);
        weaponPanel.setBounds(game.getWidth() / 4, 0, 120, 30);
        weaponPanel.setBorder(BorderFactory.createLineBorder(Color.black));



        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        try {
            BufferedImage img = ImageIO.read(new File("treeA.png"));
            tree1 = new JButton();
            tree1.setIcon(new ImageIcon(img));
            tree1.setBounds(300,game.getHeight()-700,260,465);
            tree1.setContentAreaFilled(false);
            tree1.setBorderPainted(false);
            tree1.setFocusable(false);
            layeredPane.add(tree1, new Integer(1));

            if(startDifflvl>=2) {
                JButton cloud = new JButton();
                BufferedImage cloudIcon = ImageIO.read(new File("cloudA.png"));
                cloud.setIcon(new ImageIcon(cloudIcon));
                cloud.setBounds(0,0,300,200);
                cloud.setFocusable(false);
                cloud.setContentAreaFilled(false);
                cloud.setBorderPainted(false);
                new CloudMover(game, layeredPane,cloud);
            }

            if(startDifflvl==3) {
                tree2 = new JButton();
                tree2.setIcon(new ImageIcon(img));
                tree2.setBounds(900,game.getHeight()-700,260,465);
                tree2.setFocusable(false);
                tree2.setContentAreaFilled(false);
                tree2.setBorderPainted(false);
                layeredPane.add(tree2, new Integer(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        layeredPane.add(pointPanel, new Integer(2));
        layeredPane.add(timePanel, new Integer(2));
        layeredPane.add(hpPanel, new Integer(2));
        layeredPane.add(weaponPanel, new Integer(2));
        layeredPane.setBounds(0,0,game.getWidth(), game.getHeight());


        PointsField.setEditable(false);
        hpField.setEditable(false);
        weaponField.setEditable(false);
        timeField.setEditable(false);
        game.setLayout(null);
        game.add(layeredPane);
        game.pack();
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        timeCounter = new TimeCounter(timeField, game);
        start();
    }

    @Override
    public void run() {
        // spawning ducks and making waves stronger every 5 sec
        spawnDuck();
        while (game.isVisible() && difflvl < 23) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spawnDuck();
            spawnDuck();
            difflvl++;
        }
        while (game.isVisible() && difflvl >= 23) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            duckHpMultilplyer++;
            spawnHardDuck();
            spawnDuck();
        }
    }

    void spawnDuck() {
        int temp = (int) (Math.random() * 10);
        createDuck(temp);
    }

    void spawnHardDuck() {
        int temp = 0;
        while (temp<4) {
            temp = (int) (Math.random() * 10);
        }
        createDuck(temp);
    }

    private void createDuck(int temp) {
        switch (temp) {
            case 0 -> new RightDuckMover(this);
            case 1 -> new LeftDuckMover(this);
            case 2 -> new YellowLeftDuckMover(this);
            case 3 -> new YellowRightDuckMover(this);
            case 4 -> new RedLeftDuckMover(this);
            case 5 -> new RedRightDuckMover(this);
            case 6 -> new PurpleRightDuckMover(this);
            case 7 -> new PurpleLeftDuckMover(this);
            case 8 -> new PinkLeftDuckMover(this);
            case 9 -> new PinkRightDuckMover(this);
        }
    }

    void finishGame(){
        game.dispose();
        this.interrupt();
        showUserNameFrame();

    }

    public String getUserName() {
        return userNameField.getText();
    }
    void showUserNameFrame(){
        timeCounter.interrupt();
        JPanel panel = new JPanel();
        userNameField = new JTextField("Type here your name");
        confirmName = new JButton("Confirm");
        main.setVisible(true);
        // confirm button should create object ExitScore to be saved
        confirmName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actual saving process by ExitGame class
                new SaveToFile().saveDmgToFile(Integer.parseInt(weaponField.getText()));
                new SaveToFile().savePointsToFile(Integer.parseInt(PointsField.getText()));
                new SaveToFile(new ExitScore(getUserName(), Integer.parseInt(PointsField.getText()), Integer.parseInt(timeField.getText()), startDifflvl));
                userName.dispose();
            }
        });


        userName = new JFrame("your score is: " + PointsField.getText());
        userName.setMinimumSize(new Dimension(350, 100));
        userName.add(panel, BorderLayout.CENTER);
        panel.add(userNameField, BorderLayout.NORTH);
        panel.add(confirmName, BorderLayout.SOUTH);
        userName.pack();
        userName.setLocationRelativeTo(null);
        userName.setVisible(true);
    }
}


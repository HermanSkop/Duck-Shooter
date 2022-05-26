import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunGame extends Thread {
    JFrame game;
    int startDifflvl;
    int difflvl;
    ExitShortcut listener;
    JTextField hpField;
    JTextField PointsField;
    JTextField timeField;


    JFrame userName;
    JTextField userNameField;
    JButton confirmName;

    RunGame(int difficulty) {
       // this.exitGame=exitGame;
        // creating game window
        difflvl = difficulty;
        startDifflvl = difficulty;
        game = new JFrame("Hunt them Down!");
        PointsField = new JTextField("0");
        timeField = new JTextField("0");
        hpField = new JTextField("60");
        JPanel pointPanel = new JPanel();
        JPanel timePanel = new JPanel();
        JPanel hpPanel = new JPanel();

        // implementing shortcut
        JTextField textField = new JTextField();
        listener = new ExitShortcut(this);
        textField.addKeyListener(listener);
        game.add(textField);

        game.setMinimumSize(new Dimension(1500, 1000));
        timePanel.add(timeField);
        timePanel.setBounds(game.getWidth() - 100, 0, 50, 30);
        hpPanel.add(hpField);
        hpPanel.setBounds(game.getWidth() / 2, 0, 50, 30);
        pointPanel.add(PointsField);
        pointPanel.setBounds(0, 0, 50, 30);

        //adding obstacles
        JPanel treePanel = new JPanel();


        PointsField.setEditable(false);
        hpField.setEditable(false);
        timeField.setEditable(false);
        game.setLayout(null);
        game.add(pointPanel);
        game.add(timePanel);
        game.add(hpPanel);
        game.pack();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        TimeCounter count = new TimeCounter(timeField, game);
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
            if(difflvl>27)spawnHardDuck();
            else spawnDuck();
            spawnDuck();
            difflvl++;
            System.out.println(difflvl);
        }
        while (game.isVisible() && difflvl > 30) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spawnHardDuck();
            spawnHardDuck();
            spawnDuck();
            System.out.println(difflvl);
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
        JPanel panel = new JPanel();
        userNameField = new JTextField("Type here your name");
        confirmName = new JButton("Confirm");

        // confirm button should create object ExitScore to be saved
        confirmName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actual saving process by ExitGame class
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


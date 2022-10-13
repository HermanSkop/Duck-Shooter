import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){

        JFrame main = new JFrame("Menu");
        JButton ng = new JButton("New Game");
        JButton hs = new JButton("High Scores");
        JButton shop = new JButton("Gun Shop");
        JButton exit = new JButton("Exit");
        final JFrame[] scoreFrame = {new JFrame("Score Table")};
        // creating window for difficulty level
        JFrame difflvl = new JFrame("Choose difficulty of the game");
        JButton ez = new JButton("Easy");
        JButton mid = new JButton("Middle");
        JButton hard = new JButton("Hard");

       //ExitGame exitGame = new ExitGame();
        ez.addActionListener(e -> {
            difflvl.dispose();
            main.setVisible(false);
            new RunGame(1, main);
        });
        mid.addActionListener(e -> {
           difflvl.dispose();
            main.setVisible(false);
           new RunGame(3, main);
        });
        hard.addActionListener(e -> {
            main.setVisible(false);
            difflvl.dispose();
            new RunGame(9, main);
        });

        difflvl.add(ez, BorderLayout.LINE_START);
        difflvl.add(mid, BorderLayout.CENTER);
        difflvl.add(hard, BorderLayout.LINE_END);
        difflvl.setMinimumSize(new Dimension(300,100));
        difflvl.pack();
        difflvl.setLocationRelativeTo(null);

        JLabel pointsLabel = new JLabel("You have " + new GetFromFile().getPoints() + " points to use");
        JFrame shopFrame = new JFrame("Here you can upgrade your weapon by 1 dmg");
        JButton upgrade = new JButton("Cost: " + new GetFromFile().getDmg()*10);
        shopFrame.add(pointsLabel, BorderLayout.LINE_START);
        shopFrame.add(upgrade, BorderLayout.LINE_END);
        shopFrame.setMinimumSize(new Dimension(300,100));
        shopFrame.pack();
        shopFrame.setLocationRelativeTo(null);



        shop.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               upgrade.setText("Cost: " + new GetFromFile().getDmg()*10);
               pointsLabel.setText("You have " + new GetFromFile().getPoints() + " points to use");
               shopFrame.setVisible(!shopFrame.isVisible());
           }
        });
        upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new GetFromFile().getPoints() - new GetFromFile().getDmg() * 10>=0) {
                    System.out.println(- new GetFromFile().getDmg() * 10);
                    new SaveToFile().savePointsToFile(- new GetFromFile().getDmg() * 10);
                    System.out.println(new GetFromFile().getPoints());
                    new SaveToFile().saveDmgToFile(new GetFromFile().getDmg() + 1);
                    upgrade.setText("Cost: " + new GetFromFile().getDmg() * 10);
                    pointsLabel.setText("You have " + new GetFromFile().getPoints() + " points to use");
                }
            }
        });

        hs.addActionListener(e -> {
            Container a = new GetFromFile().getCont();
            ScoreListModel tempList;
            try {
                tempList = new ScoreListModel(a.scoreList);
            }
            catch (NullPointerException c){
                a = new Container();
                tempList = new ScoreListModel(a.scoreList);
            }
            JList<ExitScore> scoreList = new JList<>(tempList);
            if(!scoreFrame[0].isVisible()) {
                JScrollPane tempScrollPane = new JScrollPane(scoreList);
                scoreFrame[0] = new JFrame("Score Table");
                scoreFrame[0].add(tempScrollPane);
                scoreFrame[0].setMinimumSize(new Dimension(150, 300));
                scoreFrame[0].pack();
                scoreFrame[0].setVisible(true);
            }
        });
        exit.addActionListener(e -> System.exit(1));
        ng.addActionListener(e -> difflvl.setVisible(!difflvl.isVisible()));
        main.add(shop, BorderLayout.PAGE_END);
        main.add(ng, BorderLayout.LINE_START);
        main.add(hs, BorderLayout.CENTER);
        main.add(exit, BorderLayout.LINE_END);

        main.setMinimumSize(new Dimension(300,150));
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}

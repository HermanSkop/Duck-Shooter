import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame main = new JFrame("Menu");
        JButton ng = new JButton("New Game");
        JButton hs = new JButton("High Scores");
        JButton exit = new JButton("Exit");
        final JFrame[] scoreFrame = {new JFrame("Score Table")};
        // creating window for difficulty level
        JFrame difflvl = new JFrame("Choose difficulty of the game");
        JButton ez = new JButton("Easy");
        JButton mid = new JButton("Middle");
        JButton hard = new JButton("Hard");

       //ExitGame exitGame = new ExitGame();
        ez.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difflvl.dispose();
                main.setVisible(false);
                new RunGame(1, main);
            }
        });
        mid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               difflvl.dispose();
                main.setVisible(false);
               new RunGame(3, main);
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                difflvl.dispose();
                new RunGame(9, main);
            }
        });

        difflvl.add(ez, BorderLayout.LINE_START);
        difflvl.add(mid, BorderLayout.CENTER);
        difflvl.add(hard, BorderLayout.LINE_END);
        difflvl.setMinimumSize(new Dimension(300,100));
        difflvl.pack();
        difflvl.setLocationRelativeTo(null);

        hs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container a = new GetFromFile().getCont();
                ScoreListModel tempList;
                try {
                    tempList = new ScoreListModel(a.scoreList);
                }
                catch (NullPointerException c){
                    a = new Container();
                    tempList = new ScoreListModel(a.scoreList);
                }
                JList scoreList = new JList(tempList);
                if(!scoreFrame[0].isVisible()) {
                    JScrollPane tempScrollPane = new JScrollPane(scoreList);
                    scoreFrame[0] = new JFrame("Score Table");
                    scoreFrame[0].add(tempScrollPane);
                    scoreFrame[0].setMinimumSize(new Dimension(150, 300));
                    scoreFrame[0].pack();
                    scoreFrame[0].setVisible(true);
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        ng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (difflvl.isVisible()) {
                    difflvl.setVisible(false);
                }
                else difflvl.setVisible(true);
            }
        });
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

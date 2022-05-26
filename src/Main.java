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
                new RunGame(1);
            }
        });
        mid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               difflvl.dispose();new RunGame(3);
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difflvl.dispose();new RunGame(9);
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
                if(a.scoreList!=null)for(Object i:a.scoreList) System.out.println(i);
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

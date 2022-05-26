import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Duck extends Thread{
    RunGame currGame;
    int hp = 1;
    JButton duck;
    JPanel panel;
    int x = -25;
    int y;

    Duck(RunGame currGame){
        this.currGame = currGame;
        // adding duck to the main window;
        duck = new JButton();
        panel = new JPanel();
        duck.setContentAreaFilled(false);
        duck.setBorderPainted(false);
        duck.setPreferredSize(new Dimension(50,50));
        duck.setLocation(0,0);

        currGame.game.setLayout(null);
        y = (int) (Math.random()*500+100);
        panel.setBounds(x, y, 50, 50);
        currGame.game.add(panel);
        panel.add(duck);
        currGame.game.pack();

        // hit
        duck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hp-=1;
                if(hp<=0){
                    currGame.PointsField.setText(String.valueOf( Integer.parseInt(currGame.PointsField.getText())+1));
                    removeDuck();
                }
            }
        });
        start();
    }
    void removeDuck(){
        duck.setIcon(null);
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        currGame.game.remove(duck);
        currGame.game.remove(panel);
        this.interrupt();
    }
    void reduceHp(int amount){
        System.out.println("hp reduced from " +currGame.hpField.getText()+" by "+amount);
        currGame.hpField.setText(String.valueOf( Integer.parseInt(currGame.hpField.getText())-amount));
        if(Integer.parseInt(currGame.hpField.getText())<=0){
            finishGame();
        }
    }
    void finishGame(){
        if(currGame.game.isVisible()) currGame.finishGame();
        else System.out.println("here");
    }

}

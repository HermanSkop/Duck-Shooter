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
        hp*=currGame.duckHpMultilplyer;
        duck = new JButton();
        panel = new JPanel();
        duck.setContentAreaFilled(false);
        duck.setBorderPainted(false);
        duck.setPreferredSize(new Dimension(50,50));
        duck.setLocation(0,0);


        currGame.game.setLayout(null);
        y = (int) (Math.random()*500+100);
        panel.setBounds(x, y, 50, 50);
        panel.setOpaque(false);
        panel.add(duck);
        currGame.layeredPane.add(panel, new Integer(0));

        currGame.game.pack();

        // hit
        duck.addActionListener(e -> {
            if(hp>0) {
                hp -= Integer.parseInt(currGame.weaponField.getText());
                if (hp <= 0) {
                    currGame.PointsField.setText(String.valueOf(Integer.parseInt(currGame.PointsField.getText()) + 1));
                    removeDuck(panel);
                }
            }
        });
        start();
    }
    void removeDuck(JPanel theDuck){
        duck.setIcon(null);
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        currGame.layeredPane.remove(theDuck);
        this.interrupt();
    }
    void reduceHp(int amount){
        if(amount>0) currGame.hpField.setText(String.valueOf( Integer.parseInt(currGame.hpField.getText())-amount));
        if(Integer.parseInt(currGame.hpField.getText())<=0){
            finishGame();
        }
    }
    void finishGame(){
        if(currGame.game.isVisible()) currGame.finishGame();
    }

}

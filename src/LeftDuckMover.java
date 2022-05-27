import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftDuckMover extends Duck{
        int x = currGame.game.getWidth()+50;
    LeftDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("duck-l.png");
        duck.setIcon(icon);
    }
        @Override
        public void run() {
            // actual movement of the duck
            while(x>-100) {
                x -= 1;
                panel.setBounds(x, y, 50, 50);
                try {
                    try {
                        sleep(64/currGame.difflvl);

                    } catch (InterruptedException e) {}
                } catch (Exception e) {}
                if(x==-50){
                    reduceHp(hp);
                    removeDuck();
                };
            }
        }
    }


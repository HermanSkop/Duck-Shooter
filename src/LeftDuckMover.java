import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftDuckMover extends Duck{
        int x = 1500;
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
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    System.out.println("sleep interrupted");
                }
                if(x==-50){
                    reduceHp(hp);
                    removeDuck();
                };
            }
        }
    }

